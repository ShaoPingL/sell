package com.example.sell.utils;

import java.util.Random;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 16:11
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
