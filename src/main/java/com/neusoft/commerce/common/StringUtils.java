package com.neusoft.commerce.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/07/21
 */
public class StringUtils {

    public static String[] splitTo(String str){
        return str.split(",");
    }



    public static List<Integer> StringConvertInter(String[] str){
        List<Integer> ids=new ArrayList<>();
        for(String string:str){
            ids.add(Integer.parseInt(string));
        }
        return ids;
    }
}
