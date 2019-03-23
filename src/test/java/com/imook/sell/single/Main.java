package com.imook.sell.single;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import java.util.ServiceConfigurationError;

/**
 * @author KnoWsea
 * @create 2019-03-17 9:28
 */
class Final extends FinalClass{
//    public static final String str = "bbb";
//    public Final(){
//        System.out.println("父类构造器");
//    }
//    static {
//        System.out.println("父类static");
//    }
//    {
//        System.out.println("父类非static");
//    }
}
class FinalClass {

    public final String str = "aaa";
    static {
        System.out.println("hello world");
    }

}

public class Main{

    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        System.out.println(finalClass.str);
    }
}