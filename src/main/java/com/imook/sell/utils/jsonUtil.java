package com.imook.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**json格式化工具
 * @author KnoWsea
 * @create 2019-01-07 14:19
 */

public class jsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
