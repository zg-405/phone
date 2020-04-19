package com.example.bitefu.service.impl;

import com.example.bitefu.mapper.SelectMobileMapper;
import com.example.bitefu.model.Shouji;
import com.example.bitefu.service.SelectMobileService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class SelectMobileServiceImpl implements SelectMobileService {
    @Resource
    private SelectMobileMapper selectMobileMapper;

    @Override
    public int SelectPhoneByMySql(String mobile) {
        return selectMobileMapper.SelectPhoneByMySql(mobile);
    }


}
