package com.imook.sell.single;

import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @author KnoWsea
 * @create 2019-03-17 9:26
 */
@ComponentScan
@Service
public class service {

    @Autowired
    private Apple apple;

    public void getApple(){
        apple.setName("ewfewf");

        apple.setAddre("fwefw");
        String address = apple.getAddre();
        String name = apple.getName();
        System.out.println(name);
    }
}
