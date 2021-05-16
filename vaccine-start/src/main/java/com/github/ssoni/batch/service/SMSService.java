package com.github.ssoni.batch.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.github.ssoni.entity.MessageLog;
import com.github.ssoni.entity.UserDetail;
import com.github.ssoni.repository.MessageRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static com.github.ssoni.batch.bean.LogType.LOG_ERROR;


@Service
public class SMSService {

    @Value("${aws.api.key}")
    private String apiKey;

    @Value("${aws.secret.key}")
    private String secretKey;
    @Value("${aws.sms.enable}")
    private String awsSMSEnable;


    @Autowired
    MessageRepo messageRepo;

    private AmazonSNS snsClient;
    private Map<String, MessageAttributeValue> smsAttributes;

    private static Logger logger= Logger.getLogger(SMSService.class);
    @PostConstruct
    private void set(){
        smsAttributes = new HashMap<>();
        smsAttributes.put("AWS.SNS.SMS.SMSType",new MessageAttributeValue().withStringValue("Transactional").withDataType("String"));
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(apiKey, secretKey);
        snsClient = AmazonSNSClientBuilder.standard()
                .withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

     void sendNotification(String userMob, String sms) {

        if("true".equals(awsSMSEnable)) {
            try {
                PublishRequest request = new PublishRequest();
                request.withMessage(sms)
                        .withPhoneNumber("+91" + userMob)
                        .withMessageAttributes(smsAttributes);
                PublishResult result = snsClient.publish(request);
                System.out.println("TXT RES :"+result);
            }catch (Exception e)
            {
                messageRepo.save(new MessageLog(0,null,"exception while sending SMS",LOG_ERROR));
            }
        }
        else{
            logger.debug("Sent :"+userMob+"  "+sms);
        }
    }

    public void notifyUser(UserDetail user, String msg) {
        try {
            String sms = "Hi " + user.getUserName() + " " + msg;
            if (sms.length() > 140) {
                sms = sms.substring(0, 140);
            }
            sendNotification(user.getUserMob(), sms);
        } catch (Exception e) {
            logger.error("error while sending sms to :" + user.getUserMob(), e);
        }
    }
}
