package com.github.ssoni.batch.service;

import com.github.ssoni.batch.bean.CenterDetail;
import com.github.ssoni.batch.bean.ResponseBean;
import com.github.ssoni.dao.VaccineDao;
import com.github.ssoni.entity.MessageLog;
import com.github.ssoni.entity.UserDetail;
import com.github.ssoni.repository.MessageRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.github.ssoni.batch.bean.LogType.LOG_ERROR;

@Service
public class PinCodeProcessing {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VaccineDao dao;

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private SMSService smsService;

    @Value("${cdn.server.url}")
    private String cdnurl;
    private static Logger logger = Logger.getLogger(PinCodeProcessing.class);

    //@Async
    public void processForPin(String pincode) {
        try {
            Thread.sleep(6000);
            String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            //String tomorrowDate = LocalDate.now().minusDays(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String dayAfterTomorrowDate = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            List<CenterDetail> list = getAvailableVaccine(pincode, tomorrowDate);
            list.addAll(getAvailableVaccine(pincode, dayAfterTomorrowDate));

            if (list.isEmpty()) {
                return;
            }
            List<CenterDetail> listOld = list.stream().filter(CenterDetail::availableForOld).collect(Collectors.toList());
            List<CenterDetail> listYoung = list.stream().filter(CenterDetail::availableForYoung).collect(Collectors.toList());


            if (!listYoung.isEmpty()) {
                StringBuilder stringBuilderYoung = new StringBuilder();
                listYoung.forEach(centerDetail -> stringBuilderYoung.append(centerDetail.getVaccine()).append(" available  at ").append(centerDetail.getName()).append(" on :").append(centerDetail.getDate()).append(". "));
                notifyVaccineFor18(pincode, stringBuilderYoung.toString());
            }
            if (!listOld.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                listOld.forEach(centerDetail -> stringBuilder.append(centerDetail.getVaccine()).append(" available  at ").append(centerDetail.getName()).append(" on :").append(centerDetail.getDate()).append(". "));
                notifyVaccineFor45(pincode, stringBuilder.toString());
            }
        }catch (Exception e){
            logger.error("Error occured while processing for pin :"+pincode,e);
            messageRepo.save(new MessageLog(0,null,"Error occured while processing for pin ",LOG_ERROR));
        }
    }

    private void notifyVaccineFor18(String pincode, String msg) {
        List<UserDetail> list = dao.findByPinAndAgeLess(pincode, 45);
        if (!list.isEmpty()) {
            list.forEach(user -> smsService.notifyUser(user, msg));
            dao.updateUsersAlreadyNotified18(pincode);
            messageRepo.save(new MessageLog(list.size(),pincode,"sms sent for 18 :"+msg));
        }
    }

    private void notifyVaccineFor45(String pincode, String msg) {
        List<UserDetail> list = dao.findByPinAndAgeMore(pincode, 44);
        if (!list.isEmpty()) {
            list.forEach(user -> smsService.notifyUser(user, msg));
            dao.updateUsersAlreadyNotified45(pincode);
            messageRepo.save(new MessageLog(list.size(),pincode,"sms sent for 45 :"+msg));
        }
    }




    private List<CenterDetail> getAvailableVaccine(String pinCode, String date) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity entity = new HttpEntity(headers);

            Map<String, String> map = new HashMap<>();
            map.put("pincode", pinCode);
            map.put("date", date);
            ResponseEntity<ResponseBean> response = restTemplate.exchange(cdnurl,
                    HttpMethod.GET, entity, ResponseBean.class, map);
            Thread.sleep(200);
            return response.getBody().getSessions();

        } catch (Exception e) {
            logger.error("error which calling cdn", e);
            messageRepo.save(new MessageLog(0,null,"Error which calling cdn ",LOG_ERROR));
            sleep();
        }
        return new ArrayList<>();
    }


    private void sleep(){
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
