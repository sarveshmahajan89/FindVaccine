package com.github.ssoni.batch.bean;

public class CenterDetail {

    private String name;
    private String address;
    private String pincode;
    private String fee_type;
    private Integer available_capacity;
    private Integer available_capacity_dose1;
    private Integer available_capacity_dose2;
    private String date;
    private String vaccine;
    private Integer min_age_limit;

    public CenterDetail() {
    }

    public CenterDetail(String name, String address, String pincode, String fee_type, Integer available_capacity, Integer available_capacity_dose1, Integer available_capacity_dose2, String date, String vaccine, Integer min_age_limit) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.fee_type = fee_type;
        this.available_capacity = available_capacity;
        this.available_capacity_dose1 = available_capacity_dose1;
        this.available_capacity_dose2 = available_capacity_dose2;
        this.date = date;
        this.vaccine = vaccine;
        this.min_age_limit = min_age_limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(Integer available_capacity) {
        this.available_capacity = available_capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public Integer getMin_age_limit() {
        return min_age_limit;
    }

    public void setMin_age_limit(Integer min_age_limit) {
        this.min_age_limit = min_age_limit;
    }

    public boolean availableForOld() {
        return  min_age_limit==45 && available_capacity_dose1>0;
    }
    public boolean availableForYoung() {
        return  min_age_limit==18 && available_capacity_dose1>0;
    }

    public Integer getAvailable_capacity_dose1() {
        return available_capacity_dose1;
    }

    public void setAvailable_capacity_dose1(Integer available_capacity_dose1) {
        this.available_capacity_dose1 = available_capacity_dose1;
    }

    public Integer getAvailable_capacity_dose2() {
        return available_capacity_dose2;
    }

    public void setAvailable_capacity_dose2(Integer available_capacity_dose2) {
        this.available_capacity_dose2 = available_capacity_dose2;
    }

    @Override
    public String toString() {
        return "CenterDetail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                ", fee_type='" + fee_type + '\'' +
                ", available_capacity=" + available_capacity +
                ", available_capacity_dose1=" + available_capacity_dose1 +
                ", available_capacity_dose2=" + available_capacity_dose2 +
                ", date='" + date + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", min_age_limit=" + min_age_limit +
                '}';
    }
}
