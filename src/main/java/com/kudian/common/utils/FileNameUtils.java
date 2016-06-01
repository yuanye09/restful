package com.kudian.common.utils;

/**
 * Created by Administrator on 2016/4/28.
 */
public class FileNameUtils {
    /**
     * 取得文件后缀
     * @param fileName
     * @return
     */
    public static String getExtName(String fileName) {
        final int offset = fileName.lastIndexOf(".");
        if (offset < 0) {
            return "";
        }
        return fileName.substring(offset +1);
    }
}
