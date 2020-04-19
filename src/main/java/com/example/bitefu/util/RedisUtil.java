package com.example.bitefu.util;

import com.alibaba.fastjson.JSON;
import com.example.bitefu.model.Shouji;
import redis.clients.jedis.Jedis;

/**
 * redis
 * 添加/查找/获取value
 */
public class RedisUtil {
    private static Jedis jedis;
    static{
        //访问本地redis
        jedis = new Jedis("127.0.0.1",6379);
    }

    //检查给定key是否存在
    public static boolean jedisExists(String string){
        return jedis.exists(string);
    }

    //存放数据到redis数据库中
    public static String addRedis(Shouji mobile){
        //key
        String key = mobile.getMobile();
        //value
        String value = JSON.toJSONString(mobile);
        //存放到redis
        return jedis.set(key, value);
    }

    public static Boolean selectForRedis(String mobile){
        //查询redis中是否有该数据，返回true/false
        if("true".equals(jedis.exists(mobile))){
            return true;
        }
        return false;
    }

    public static String getValue(String key){
        String value = null;
        //获取key对应的数据类型
        String type = jedis.type(key);
        if(type.equals("string")){
            //get(key)方法返回key所关联的字符串值
            value = jedis.get(key);
        }
        return value;
    }


}
