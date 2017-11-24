package com.example.concurrent.deadlock;

/**
 * Created by BigFaceBear on 2017.11.24
 */

public class DeadLock {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        //两个方法使用同一把锁，两个线程同时各自调用其中一个方法，
        //因为两个方法使用了同一把锁，两个方法不能被同时执行，必须
        //等待其中的一个方法释放了锁对象，另一个方法才能够被执行。
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.a();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.b();
//            }
//        }).start();

        //两个方法使用不同的锁，就可以同时被执行
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.c();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                deadLock.d();
//            }
//        }).start();

        //锁对象是全局的，一旦某处持有了锁对象，那么其他任何线程需要用到这个锁，
        //就需要等待。
        DeadLockBrother lockBrother = new DeadLockBrother();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.d();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lockBrother.d();
            }
        }).start();
    }

    public synchronized void a() {
        System.out.println("methed a");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println("method a sleep was interrupted");
        }
    }

    public synchronized void b() {
        System.out.println("methed b");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            System.out.println("method b sleep was interrupted");
        }
    }

    public void c() {
        synchronized (this) {
            System.out.println("methed c");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println("method a sleep was interrupted");
            }
        }
    }

    public void d() {
        synchronized (DeadLock.class) {
            System.out.println("methed d");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                System.out.println("method b sleep was interrupted");
            }
        }
    }

}

class DeadLockBrother {
    public void d() {
        synchronized (DeadLock.class) {
            System.out.println("methed d in brother");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                System.out.println("method b sleep was interrupted");
            }
        }
    }
}

