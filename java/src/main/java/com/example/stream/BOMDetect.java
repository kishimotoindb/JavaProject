package com.example.stream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by BigFaceBear on 2018.10.29
 */

public class BOMDetect {
    public static void main(String[] args) throws IOException {
        File file = new File("manifest.xml");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] result = new byte[3];
            fis.read(result);
            System.out.println(new String(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

    }
}
