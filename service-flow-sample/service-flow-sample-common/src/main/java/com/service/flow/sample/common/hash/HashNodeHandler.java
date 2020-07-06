package com.service.flow.sample.common.hash;

import java.util.*;

/**
 * @author zhangcb
 * @ClassName HashNodeHandler.java
 * @Description TODO
 * @createTime 2020年07月05日 16:00:00
 */
public class HashNodeHandler {

    private List<String> nodes;

    private TreeMap<Integer, String> virtualNodes = new TreeMap<>();

    private TreeMap<String, Integer> serverVisit = new TreeMap<>();

    private int nodeNum;

    public HashNodeHandler(List<String> nodes,Integer nodeNum){
        this.nodes = nodes;
        this.nodeNum = nodeNum;
    }

    public void calculation(){
        nodes.forEach(s -> {
            serverVisit.put(s, 0);
            for (int i = 0; i < nodeNum; i++) {
                virtualNodes.put(hash(s + "NODE=" + i), s);
            }
        });

    }

    public void put(Object object){
        int hash = hash(object);
        SortedMap<Integer, String> integerStringSortedMap = virtualNodes.tailMap(hash);
        String server = "";
        if (integerStringSortedMap.isEmpty()) {
            // 如果没有比reqHash大的值，则返回第一个虚拟服务器节点
            server = virtualNodes.get(virtualNodes.firstKey());
        } else {
            // greaterMap第一个值就是顺时针下离reqHash最近的虚拟服务器节点
            server = integerStringSortedMap.get(integerStringSortedMap.firstKey());
        }
        serverVisit.put(server, serverVisit.get(server) + 1);
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public double calculationStandard() {
        Integer[] visitData = new Integer[serverVisit.size()];
        serverVisit.values().toArray(visitData);
        double avg = Arrays.stream(visitData).mapToInt(Integer::intValue).average().orElse(0d);
        double avgStd = Arrays.stream(visitData).map(count -> Math.pow(count - avg, 2)).mapToDouble(Double::doubleValue).average().orElse(0d);
        double std = Math.sqrt(avgStd);
        return std;
    }

    public TreeMap<String, Integer> getServerVisit() {
        return serverVisit;
    }

}
