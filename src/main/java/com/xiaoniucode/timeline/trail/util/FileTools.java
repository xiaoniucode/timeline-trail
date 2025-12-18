package com.xiaoniucode.timeline.trail.util;

import java.nio.file.FileSystems;

/**
 * @author liuxin
 */
public class FileTools {
    public static String getUploadPath(String projectName) {
        String fileSeparator = FileSystems.getDefault().getSeparator();
        return  System.getProperty("user.home") + fileSeparator + projectName + fileSeparator + "upload" + fileSeparator;
    }

    public static void main(String[] args) {
        System.out.println(getUploadPath("a"));
    }
}
