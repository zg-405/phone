package com.example.bitefu.service.impl;

import com.example.bitefu.mapper.InsertMobileMapper;
import com.example.bitefu.model.Shouji;
import com.example.bitefu.service.InsertMobileService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class InsertMobileServiceImpl implements InsertMobileService {
    @Resource
    private InsertMobileMapper insertMobileMapper;

    @Override
    public int InsertPhoneByMySql(Shouji mobile) {
        return insertMobileMapper.InsertPhoneByMySql(mobile);
    }
}
