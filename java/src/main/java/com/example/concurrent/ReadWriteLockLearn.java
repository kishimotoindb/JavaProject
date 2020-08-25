package com.example.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by cuihaichen on 2020.06.27
 */
public class ReadWriteLockLearn {

    ReadWriteLock mLock = new ReentrantReadWriteLock();
    Condition mCondition = mLock.writeLock().newCondition();

    public static void main(String[] args) {
        final ReadWriteLockLearn learn = new ReadWriteLockLearn();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    learn.get();
                }
            }).start();
        }

//        try {
//            Thread.sleep(10 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        learn.put();
    }

    void get() {
        mLock.readLock().lock();
        try {
            //mCondition.await();
            System.out.println("excute after await()");
            //} catch (InterruptedException e) {

        } finally {
            mLock.readLock().unlock();
            System.out.println("read lock unlock");
        }
    }

    void put() {
        mLock.writeLock().lock();
        try {
            mCondition.await();
            System.out.println("await");
        } catch (Exception e) {

        } finally {
            mLock.writeLock().unlock();
            System.out.println("unlock");
        }
    }
}
