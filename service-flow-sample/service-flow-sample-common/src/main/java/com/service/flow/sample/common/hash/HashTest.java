package com.service.flow.sample.common.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcb
 * @ClassName HashTest.java
 * @Description TODO
 * @createTime 2020年07月05日 15:53:00
 */
public class HashTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("192.168.0.1");
        list.add("192.168.0.2");
        list.add("192.168.0.3");
        list.add("192.168.0.4");
        list.add("192.168.0.5");
        list.add("192.168.0.6");
        list.add("192.168.0.7");
        list.add("192.168.0.8");
        list.add("192.168.0.9");
        list.add("192.168.0.10");
        list.add("192.168.0.11");
        list.add("192.168.0.12");
        list.add("192.168.0.13");
        int num = 200;
        HashNodeHandler hashNodeHandler = new HashNodeHandler(list, num);
        hashNodeHandler.calculation();
        test1000000(hashNodeHandler);
    }

    private static void test1000000(HashNodeHandler hashNodeHandler) {
        int num = 1000000;
        loop(hashNodeHandler,num);
    }

    private static void loop(HashNodeHandler hashNodeHandler,int num) {
        for (int i = 0; i < num; i++) {
            hashNodeHandler.put(i+"nodeDa");
        }
        System.out.println(hashNodeHandler.getServerVisit());
        System.out.println(hashNodeHandler.calculationStandard());

    }

}
