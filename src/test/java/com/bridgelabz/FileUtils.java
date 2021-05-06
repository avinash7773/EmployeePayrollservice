package com.bridgelabz;

import java.io.File;

public class FileUtils {

    /**
     *  @deleteFiles method is for delete file if file exists
     */
    public static boolean deleteFiles(File contendDelete) {
        File[] allContents = contendDelete.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteFiles(file);
            }
        }
        return contendDelete.delete();
    }
}
