package com.example.Basic.concurrent._volatile;

/**
 * Created by BigFaceBear on 2017.11.25
 */

public class VolatileTest {

    public volatile boolean shutdown = false;

    public void shutdown() {
        shutdown = true;
    }

    public void exec() {
        while (!shutdown) {
            System.out.println("程序执行中");
        }
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                test.exec();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                test.shutdown();
                System.out.println(System.currentTimeMillis());
            }
        }).start();
    }

}
