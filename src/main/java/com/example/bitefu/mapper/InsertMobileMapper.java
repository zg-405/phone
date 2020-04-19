package com.example.bitefu.mapper;

import com.example.bitefu.model.Shouji;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsertMobileMapper {

    //传入一个Mobile对象，存储到数据库中
    public int InsertPhoneByMySql(@Param("mobile") Shouji mobile);

}
