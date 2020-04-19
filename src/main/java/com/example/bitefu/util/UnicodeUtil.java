package com.example.bitefu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unicode转中文
 * 去符号
 */
public class UnicodeUtil {
    public static String unicodeToCn(String string) {
            Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
            Matcher matcher = pattern.matcher(string);
            char ch;
            while (matcher.find()) {
                ch = (char) Integer.parseInt(matcher.group(2), 16);
                string = string.replace(matcher.group(1), ch + "");
            }
            //去字符
            string=string.replace("{","");
            string=string.replace("}","");
            string=string.replace("/","");
            string=string.replace("\\","");
            return string;
    }
}
