package com.example.bitefu.model;

import java.io.Serializable;

public class Shouji implements Serializable {
    private String isp;
    private String province;
    private String city;
    private String postcode;
    private String citycode;
    private String areacode;
    private String status;
    private String mobile;

    public Shouji() {
    }

    public Shouji(String isp, String province, String city, String postcode, String citycode, String areacode, String status, String mobile) {
        this.isp = isp;
        this.province = province;
        this.city = city;
        this.postcode = postcode;
        this.citycode = citycode;
        this.areacode = areacode;
        this.status = status;
        this.mobile = mobile;
    }


    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
