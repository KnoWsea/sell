package com.imook.sell.beanLife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author KnoWsea
 * @create 2019-02-28 13:38
 */
@SpringBootApplication
public class MainConfig {
    public static void main(String[] args) {
        SpringApplication.run(MainConfig.class,args);
    }
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public Userone user(){
        return new Userone();
    }
}