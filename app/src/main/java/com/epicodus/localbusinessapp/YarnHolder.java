package com.epicodus.localbusinessapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guest on 11/17/16.
 */
public class YarnHolder {
    private static Map<String, String> strands;
    public static Map<String, String> getData() {
        if(strands == null){
            strands = new HashMap<String, String>();
        }
        return strands;
    }
    public static void setData(HashMap<String, String> data) {YarnHolder.strands = data;}
}

