package com.imook.sell.utils;

import com.imook.sell.enums.CodeEnum;

/**
 * @author KnoWsea
 * @create 2018-12-31 14:57
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass ) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (code.equals(enumConstant.getCode())) {
                return enumConstant;
            }
        }
        return null;
    }
}
