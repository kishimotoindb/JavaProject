package com.example.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by BigFaceBear on 2018.11.29
 */

public class OpenSameFile {
    public static void main(String[] args) {

//        try {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    long start = System.currentTimeMillis();

                    final File test = new File("test");
                    FileInputStream fis = new FileInputStream(test);
                    StringBuilder sb = new StringBuilder();
                    int b = -1;
                    while ((b = fis.read()) != -1) {
                        sb.append(((byte) b));
                    }

                    System.out.println("read " + (System.currentTimeMillis() - start));
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("read error");
                }
            }
        }).start();

//            // 读取文件
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("read start");
//                        FileOutputStream fos = new FileOutputStream(test);
//                        String s = "读取";
//                        for (int i = 0; i < 100; i++) {
//                            fos.write(s.getBytes());
//                            fos.flush();
//                            Thread.sleep(1);
//                        }
//                        fos.close();
//                        System.out.println("read end");
//                    } catch (Exception e) {
//                        System.out.println("read error");
//                    }
//                }
//            }).start();

//            // 写文件
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("write start");
//                        FileOutputStream fos = new FileOutputStream(test);
//                        String s = "存储";
//                        for (int i = 0; i < 100; i++) {
//                            fos.write(s.getBytes());
//                            fos.flush();
//                            Thread.sleep(1);
//                        }
//
//                        fos.close();
//                        System.out.println("write end");
//                    } catch (Exception e) {
//                        System.out.println("write error");
//                    }
//                }
//            }).start();


//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
