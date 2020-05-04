package com.zcc.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void main(String[] args) {
        /**
         * 解决方案
         * 1.List<String> list = new Vector<>()
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>())
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         */
        /*
            CopyOnWrite写入时复制
         */
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        //出现并发问题
        //List<String> list = new ArrayList<>();
        //List<String> list = new CopyOnWriteArrayList<>();

        for(int i=1 ; i<=10 ; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
