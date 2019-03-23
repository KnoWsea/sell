package com.imook.sell;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import reactor.util.concurrent.WaitStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KnoWsea
 * @create 2018-12-29 14:32
 */
@Component
public class Person  {
    private static volatile Person instance = null;

    private Person() {
    }

    public static Person getInstance() {

        if (instance == null) {
            synchronized (Person.class) {
                if (instance == null)
                    instance = new Person();
            }
        }
        return instance;
    }

}

 class CyclicBarrierTest {
    boolean finalFlg = false;
    /**
     * CyclicBarrier 适用再多线程相互等待，直到到达一个屏障点。并且CyclicBarrier是可重用的。
     */
    CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    private void runThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(createThread(i));
        }
    }

    private Thread createThread(int i) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println(Person.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("name" + i);
        return thread;
    }

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.runThread();
    }
}
