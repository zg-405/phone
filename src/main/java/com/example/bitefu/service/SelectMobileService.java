package com.example.bitefu.service;

import com.example.bitefu.model.Shouji;


public interface SelectMobileService {
    //查询数据库中是否有该对象
    public int SelectPhoneByMySql(String mobile);

}
