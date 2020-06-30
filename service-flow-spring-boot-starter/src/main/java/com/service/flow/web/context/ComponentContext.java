package com.service.flow.web.context;

import com.service.flow.index.component.ComponentDefinition;
import com.service.flow.index.dto.DTODefinition;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowContext.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class ComponentContext {

    private Map<String, ComponentDefinition> componentDefinitionMap;

    public Map<String, ComponentDefinition> getComponentDefinitionMap() {
        return componentDefinitionMap;
    }

    public void setComponentDefinitionMap(Map<String, ComponentDefinition> componentDefinitionMap) {
        this.componentDefinitionMap = componentDefinitionMap;
    }

    @Override
    public String toString() {
        return "ComponentContext{" +
                "componentDefinitionMap=" + componentDefinitionMap +
                '}';
    }
}
