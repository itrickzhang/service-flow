package com.service.flow.web.context;

import com.service.flow.model.FlowDefintion;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowContext.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowContext {

    private Map<String, FlowDefintion> flowDefintitionMap;

    public Map<String, FlowDefintion> getFlowDefintitionMap() {
        return flowDefintitionMap;
    }

    public void setFlowDefintitionMap(Map<String, FlowDefintion> flowDefintitionMap) {
        this.flowDefintitionMap = flowDefintitionMap;
    }

    public FlowDefintion getFlowDefinition(String flowId){
        return flowDefintitionMap.get(flowId);
    }

    @Override
    public String toString() {
        return "FlowContext{" +
                "flowDefintitionMap=" + flowDefintitionMap +
                '}';
    }
}
