package com.example.bitefu.util;

import com.example.bitefu.model.Shouji;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 访问网站
 * 不需要考虑ajax跨域
 */

public class InputStreamUrlForMobile {

//传入手机号，访问url，返回对象或者null
    public static Shouji main(String mobiles) {
        Shouji mobile= new Shouji(); ;
        try {
            //创建一个URL实例
            URL url = new URL("https://tool.bitefu.net/shouji/?mobile=" + mobiles);
            //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();//读取数据
            String info = data.substring(data.indexOf("\"status\":") + 9, data.indexOf("\"status\":") + 10);
            String data2 = data;
            br.close();
            isr.close();
            is.close();

            //正常
            if (info.equals("1")) {
                mobile.setIsp(data2.substring(data2.indexOf("\"isp\":") + 7, data2.indexOf("\",")));
                mobile.setProvince(data2.substring(data2.indexOf("\"province\":") + 12, data2.indexOf("\",\"city\"")));
                mobile.setCity(data2.substring(data2.indexOf("\"city\":") + 8, data2.indexOf("\",\"postcode\"")));
                mobile.setPostcode(data2.substring(data2.indexOf("\"postcode\":") + 12, data2.indexOf("\",\"citycode\"")));
                mobile.setCitycode(data2.substring(data2.indexOf("\"citycode\":") + 12, data2.indexOf("\",\"areacode\"")));
                mobile.setAreacode(data2.substring(data2.indexOf("\"areacode\":") + 12, data2.indexOf("\",\"status\"")));
                mobile.setStatus(data2.substring(data2.indexOf("\"status\":") + 9, data2.indexOf(",\"mobile\"")));
                String num02 = data2.substring(data2.indexOf("\"mobile\":\"") + 10);
                mobile.setMobile(num02.substring(0, num02.length() - 2));
                return mobile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
