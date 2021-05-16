package com.github.ssoni.service;

import com.github.ssoni.dao.VaccineDao;
import com.github.ssoni.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

    @Autowired
    VaccineDao dao;

    public void saveDetails(UserData userData) {
        dao.saveDetails(userData);

    }
}