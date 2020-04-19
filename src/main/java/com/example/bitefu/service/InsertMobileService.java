package com.example.bitefu.service;

import com.example.bitefu.model.Shouji;
import io.lettuce.core.dynamic.annotation.Param;


public interface InsertMobileService {

    //传入一个Mobile对象，存储到数据库中
    public int InsertPhoneByMySql(@Param("mobile") Shouji mobile);

}
