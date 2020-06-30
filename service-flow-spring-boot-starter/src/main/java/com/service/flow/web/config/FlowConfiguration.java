package com.service.flow.web.config;

import com.service.flow.index.component.BaseComponentClassLoader;
import com.service.flow.index.dto.DTOClassLoader;
import com.service.flow.support.FlowDefintitionFactory;
import com.service.flow.web.context.ComponentContext;
import com.service.flow.web.context.DtoContext;
import com.service.flow.web.context.FlowContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhangcb
 * @ClassName FlowConfiguration.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
@Configuration
public class FlowConfiguration {

    private String scanName = "com.service.flow";

    @Bean
    public FlowContext flowContext(){
        FlowDefintitionFactory flowDefintitionFactory = new FlowDefintitionFactory();
        flowDefintitionFactory.initDefintionFactory();
        FlowContext flowContext = new FlowContext();
        flowContext.setFlowDefintitionMap(flowDefintitionFactory.flowDefintitionMap);
        return flowContext;
    }

    @Bean
    public DtoContext dtoContext(){
        DTOClassLoader dtoClassLoader = new DTOClassLoader();
        dtoClassLoader.load(scanName);
        DtoContext dtoContext = new DtoContext();
        dtoContext.setDtoDefinitionMap(dtoClassLoader.getDtoDefinitionMap());
        return dtoContext;
    }

    @Bean
    public ComponentContext componentContext(){
        BaseComponentClassLoader baseComponentClassLoader = new BaseComponentClassLoader();
        baseComponentClassLoader.load(scanName);
        ComponentContext componentContext = new ComponentContext();
        componentContext.setComponentDefinitionMap(baseComponentClassLoader.getComponentDefinitionMap());
        return componentContext;
    }

}
