package com.github.ssoni.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_detail_v2")
public class UserDetail {
    @Id
    private String pkey;

    private int age;
    private String userMob;
    private String userName;
    private String pin;
    private Date registrationBy;
    private boolean messageSent;

    public UserDetail() {
    }

    public UserDetail(int age, String userName, String userMob, String pin, boolean messageSent,Date registrationBy) {
        this.pkey = userMob+pin+age;
        this.age = age;
        this.userName = userName;
        this.userMob = userMob;
        this.pin = pin;
        this.messageSent = messageSent;
        this.registrationBy= registrationBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetail that = (UserDetail) o;

        if (age != that.age) return false;
        if (messageSent != that.messageSent) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userMob != null ? !userMob.equals(that.userMob) : that.userMob != null) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        return registrationBy != null ? registrationBy.equals(that.registrationBy) : that.registrationBy == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userMob != null ? userMob.hashCode() : 0);
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (registrationBy != null ? registrationBy.hashCode() : 0);
        result = 31 * result + (messageSent ? 1 : 0);
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


    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }

    public Date getRegistrationBy() {
        return registrationBy;
    }

    public void setRegistrationBy(Date registrationBy) {
        this.registrationBy = registrationBy;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "userMob='" + userMob + '\'' +
                ", pkey='" + pkey + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", pin='" + pin + '\'' +
                ", registrationBy=" + registrationBy +
                ", messageSent=" + messageSent +
                '}';
    }
}
