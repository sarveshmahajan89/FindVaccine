package com.github.ssoni.dao;

import com.github.ssoni.entity.UserDetail;
import com.github.ssoni.model.UserData;
import com.github.ssoni.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VaccineDao {

    @Autowired
    UserDetailRepo userDetailRepo;


    public void saveDetails(UserData userData) {
        userDetailRepo.save(new UserDetail(userData.getAge(), userData.getUserName(),
                userData.getUserMob(), userData.getPin(), false,Calendar.getInstance().getTime()));
    }

    public List<UserDetail> getDetails() {
        return userDetailRepo.findAll();
    }

    public List<String> findAllPin() {
        return userDetailRepo.findDistPin();
    }

    public List<UserDetail> findByPinAndAgeLess(String pincode, int age) {
        return userDetailRepo.findByPinAndAgeLess(pincode,age);
    }

    public List<UserDetail> findByPinAndAgeMore(String pincode, int age) {
        return userDetailRepo.findByPinAndAgeMore(pincode,age);
    }

    public void updateUsersAlreadyNotified18(String pincode) {
        userDetailRepo.updateUsersAlreadyNotified18(pincode);
    }
    public void updateUsersAlreadyNotified45(String pincode) {
        userDetailRepo.updateUsersAlreadyNotified45(pincode);
    }
}
