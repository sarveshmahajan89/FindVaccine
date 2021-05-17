package com.github.ssoni.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class UserData {
    private int age;
    private String userName;
    @Size(max = 10,min = 10,message = "please enter correct Mobile")
    private String userMob;
    @Size(max = 6,min = 6,message = "please enter correct pin")
    private String pin;
    private Date targetDate;
    private boolean messageSent;
    private String vaccinedose;

    public UserData() {
    }

    public UserData(int age, String userName, String userMob, String pin, Date targetDate, boolean messageSent, String vaccinedose) {
        this.age = age;
        this.userName = userName;
        this.userMob = userMob;
        this.pin = pin;
        this.targetDate = targetDate;
        this.messageSent = messageSent;
        this.vaccinedose = vaccinedose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (age != userData.age) return false;
        return userMob.equals(userData.userMob);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + userMob.hashCode();
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMob() {
        return userMob;
    }

    public void setUserMob(String userMob) {
        this.userMob = userMob;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }

    public String getVaccinedose() {
        return vaccinedose;
    }

    public void setVaccinedose(String vaccinedose) {
        this.vaccinedose = vaccinedose;
    }
}
