package com.example.bitefu.mapper;

import com.example.bitefu.model.Shouji;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectMobileMapper {

    //查询数据库中是否有该对象
    public int SelectPhoneByMySql(String getMobile);

}
