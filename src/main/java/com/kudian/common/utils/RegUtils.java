package com.kudian.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/4/16.
 */
public class RegUtils {

    /**
     * 是否邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 是否手机号
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobileNO("ddddddddddddddddddddddddffffffffffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeessssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssgggggggggggggggggggggggggeeeeee"));

        System.out.println(isEmail("gldream@163.com"));
        System.out.println(isMobileNO("13821286530"));
    }
}
