package com.github.ssoni.batch.service;

import com.github.ssoni.dao.VaccineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BatchProcess {
    @Autowired
    private VaccineDao dao;

    @Autowired
    PinCodeProcessing pinCodeProcessing;

    public void process() {
        List<String> pinDetails = dao.findAllPin();
        if(pinDetails.isEmpty()){
            return;
        }
        pinDetails.forEach(pin -> pinCodeProcessing.processForPin(pin));
    }
}
