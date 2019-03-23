package com.imook.sell.single;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.inject.Singleton;

/**
 * @author KnoWsea
 * @create 2019-03-01 20:41
 */
public class SingleTon {
    private volatile static SingleTon uniqueInstance;

    private SingleTon(){
    }

    public static SingleTon getUnuqueInstance(){
        if(uniqueInstance == null){
            //类对象加锁
            synchronized(Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }
}
