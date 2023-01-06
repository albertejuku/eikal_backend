package com.eikal.util;

public class Utils {
    public static String getFileExtension(String filename) {
        String[] fileParts = filename.split("\\.");
        return fileParts[fileParts.length - 1];
    }

}
