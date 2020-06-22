package com.service.flow.web.config;

import com.service.flow.model.FlowDefintition;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowContext.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowContext {

    private Map<String, FlowDefintition> flowDefintitionMap;

    public Map<String, FlowDefintition> getFlowDefintitionMap() {
        return flowDefintitionMap;
    }

    public void setFlowDefintitionMap(Map<String, FlowDefintition> flowDefintitionMap) {
        this.flowDefintitionMap = flowDefintitionMap;
    }

    public FlowDefintition getFlowDefinition(String flowId){
        return flowDefintitionMap.get(flowId);
    }

    @Override
    public String toString() {
        return "FlowContext{" +
                "flowDefintitionMap=" + flowDefintitionMap +
                '}';
    }
}
