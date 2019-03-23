package com.imook.sell.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * @author KnoWsea
 * @create 2019-03-17 10:23
 */
@ComponentScan
@Controller
class controller {
    @Autowired
    private service service;

    public void getApple() {
        service.getApple();
    }

}
