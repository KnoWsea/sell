package com.imook.sell.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author KnoWsea
 * @create 2019-02-28 13:35
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass()== Userone.class){
            System.out.println("调用postProcessBeforeInitialization...");
        }
        return bean;
    }
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass()== Userone.class){
            System.out.println("调用postProcessAfterInitialization...");
        }
        return bean;
    }
}