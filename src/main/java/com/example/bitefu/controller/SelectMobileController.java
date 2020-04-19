package com.example.bitefu.controller;

import com.example.bitefu.model.Shouji;
import com.example.bitefu.service.InsertMobileService;
import com.example.bitefu.service.SelectMobileService;
import com.example.bitefu.util.InputStreamUrlForMobile;
import com.example.bitefu.util.RedisUtil;
import com.example.bitefu.util.UnicodeUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SelectMobileController {

    @Resource
    private SelectMobileService selectMobileService;
    @Resource
    private InsertMobileService insertMobileService;


    @ResponseBody
    @GetMapping("/returnMobile")
    public String returnMobile(String mobiles){
        String result = "";
        //查询redis
        boolean bool = RedisUtil.selectForRedis(mobiles);
        //如果redis没有,查询数据库
        if(bool==false){
            //查询数据库
            int numForMySQL = selectMobileService.SelectPhoneByMySql(mobiles);
            //获取网页
            Shouji mobile = InputStreamUrlForMobile.main(mobiles);
             //如果数据库也没有
            if(numForMySQL==0){
                //网页还有次数
                if(null!=mobile){
                    //插入数据库
                    int insertForMySQL = insertMobileService.InsertPhoneByMySql(mobile);
                    //插入redis
                    RedisUtil.addRedis(mobile);
                    if(insertForMySQL>0){
                        result="mysqlAndRedis00";
                    }
                }else {
                    //今日使用次数已用完,请购买独享apikey!
                    //网页访问失败
                    result = "status0";
                }
            }else {
                //数据库已存在，redis没有
                //插入rediss
                //网页还有次数
                if(null!=mobile){
                    String addRedisIsOK = RedisUtil.addRedis(mobile);
                    if("OK".equals(addRedisIsOK)){
                        //插入redis成功
                        result="mysql00Redis01addRedisIsOK";
                    }else{
                        result="mysql00Redis01addRedisIsError";
                    }
                }else{
                    //今日使用次数已用完,请购买独享apikey!
                    //网页访问失败
                    result = "status0";
                }


            }
        }else{
            //redis存在
            result="mysqlRedis";
        }
            return result;
    }

    //查询redis
    @ResponseBody
    @GetMapping("/selectRedisByMobiles")
    public String selectRedisByMobiles(String mobiles){
        //根据手机号去redis查询value，
        String unicodeToCnMobile = UnicodeUtil.unicodeToCn(RedisUtil.getValue(mobiles));
        return unicodeToCnMobile;
    }
}