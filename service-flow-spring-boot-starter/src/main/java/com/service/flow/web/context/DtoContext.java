package com.service.flow.web.context;

import com.service.flow.index.dto.DTODefinition;
import com.service.flow.model.FlowDefintion;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowContext.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
public class DtoContext {

    private Map<String, DTODefinition> dtoDefinitionMap;

    public Map<String, DTODefinition> getDtoDefinitionMap() {
        return dtoDefinitionMap;
    }

    public void setDtoDefinitionMap(Map<String, DTODefinition> dtoDefinitionMap) {
        this.dtoDefinitionMap = dtoDefinitionMap;
    }

    @Override
    public String toString() {
        return "DtoContext{" +
                "dtoDefinitionMap=" + dtoDefinitionMap +
                '}';
    }
}
