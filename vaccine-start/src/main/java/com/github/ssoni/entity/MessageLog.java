package com.github.ssoni.entity;

import com.github.ssoni.batch.bean.LogType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.github.ssoni.batch.bean.LogType.LOG_MSG;

@Entity
public class MessageLog {
    @Id
    private String id;
    private String type;
    private int userCount;
    private String pinCode;
    private String message;

    public MessageLog() {
    }

    public MessageLog(int userCount, String pinCode, String message) {
        this.id=LocalDateTime.now(ZoneId.of("Asia/Kolkata")).toString();
        this.type=LOG_MSG;
        this.userCount = userCount;
        this.pinCode = pinCode;
        if(null != message && message.length()>200){
            message=message.substring(0,200);
        }
        this.message = message;
    }

    public MessageLog(int userCount, String pinCode,String message, String type) {
        this.id=LocalDateTime.now(ZoneId.of("Asia/Kolkata")).toString();
        this.type=type;
        this.userCount = userCount;
        this.pinCode = pinCode;
        if(null != message && message.length()>200){
            message=message.substring(0,200);
        }
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
