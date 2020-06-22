package com.service.flow.model;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName BaseTemp.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class BaseTemp {

    private Long totalTime;

    private StringBuffer flowRecord;

    private Map<String,Object> context;

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public StringBuffer getFlowRecord() {
        return flowRecord;
    }

    public void setFlowRecord(StringBuffer flowRecord) {
        this.flowRecord = flowRecord;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "BaseTemp{" +
                "totalTime=" + totalTime +
                ", flowRecord=" + flowRecord +
                ", context=" + context +
                '}';
    }
}
