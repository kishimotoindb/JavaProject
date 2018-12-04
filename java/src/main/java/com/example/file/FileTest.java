package com.example.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by BigFaceBear on 2018.10.17
 */

public class FileTest {
    public static void main(String[] args) throws IOException {
        File source = new File("source");
        source.createNewFile();
        File dest = new File("dest");
        source.renameTo(dest);
        source.createNewFile();
    }
}
