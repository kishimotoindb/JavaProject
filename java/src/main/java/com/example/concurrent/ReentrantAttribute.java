package com.example.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by BigFaceBear on 2020.06.21
 */
public class ReentrantAttribute {
    final Object mSyncLock = new Object();
    final ReentrantLock mReentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        final Thread syncT = new Thread(new Runnable() {
            @Override
            public void run() {
                new ReentrantAttribute().reentrantLockReentrant();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    syncT.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new ReentrantAttribute().synchronizedReentrant();
            }
        }).start();

        syncT.start();
    }

    private void reentrantLockReentrant() {
        rlEnter();
    }

    private void synchronizedReentrant() {
        syncEnter();
    }

    private void syncEnter() {
        synchronized (mSyncLock) {
            System.out.println("syncEnter");
            syncReentrant();
        }
    }

    private void syncReentrant() {
        System.out.println("syncReentrant before lock");
        synchronized (mSyncLock) {
            System.out.println("syncReentrant after lock");
        }
    }

    private void rlEnter() {
        mReentrantLock.lock();
        try {
            System.out.println("rlEnter");
            rlReentrant();
        } finally {
            mReentrantLock.unlock();
        }
    }

    private void rlReentrant() {
        System.out.println("rlReentrant before lock");
        mReentrantLock.lock();
        try {
            System.out.println("rlReentrant after lock");
        } finally {
            mReentrantLock.unlock();
        }
    }
}
