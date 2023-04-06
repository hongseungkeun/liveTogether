package com.develop.liveTogether.global.util;

import java.io.File;

public class FileUtil {
    private static final String FILE_PATH = System.getProperty("user.dir") + "\\upload";

    public static String getFilePath(String houseFileName) { return FILE_PATH + File.separator + houseFileName; }

    public static String extractExt(String houseFileNameOriginal) {
        int pos = houseFileNameOriginal.lastIndexOf(".");
        return houseFileNameOriginal.substring(pos + 1);
    }
}
