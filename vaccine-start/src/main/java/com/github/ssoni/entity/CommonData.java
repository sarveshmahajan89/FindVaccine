package com.github.ssoni.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommonData {
    @Id
    private int data;
    private int registeredVal;
    private int totalvalue;

    public CommonData() {
    }

    public CommonData(int data, int registeredVal, int totalvalue) {
        this.data = data;
        this.registeredVal = registeredVal;
        this.totalvalue = totalvalue;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getRegisteredVal() {
        return registeredVal;
    }

    public void setRegisteredVal(int registeredVal) {
        this.registeredVal = registeredVal;
    }

    public int getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(int totalvalue) {
        this.totalvalue = totalvalue;
    }
}
