package com.zyj.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: JUC
 * @ClassName ThreadDemo04
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 14:08
 * @Package: com.zyj.lock
 * @Description: 测试List集合线程不安全
 */
public class ThreadDemo04 {

    public static void main(String[] args) {

        /**
         * ArrayList线程不安全问题
         */
        // 创建ArrayList集合
//        List<String> list = new ArrayList<>();
        // Vector解决
//        List<String> list = new Vector<>();
        // Collections解决
//        List<String> list = Collections.synchronizedList(new ArrayList<>());

//        List<String> list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()-> {
//                // 向集合添加内容
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                // 从集合中获取内容
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        /**
         * HashSet线程不安全问题
         */
//        Set<String> set = new CopyOnWriteArraySet<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()-> {
//                // 向集合添加内容
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                // 从集合中获取内容
//                System.out.println(set);
//            }, String.valueOf(i)).start();
//        }

        /**
         * HashMap线程不安全问题
         */
        Map<String,Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()-> {
                // 向集合添加内容
                map.put(key, UUID.randomUUID().toString().substring(0,8));
                // 从集合中获取内容
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }

}
