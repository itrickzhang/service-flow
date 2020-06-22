package com.service.flow.web.config;

import com.service.flow.support.FlowDefintitionFactory;
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
    @Bean
    public FlowContext flowContext(){
        FlowDefintitionFactory flowDefintitionFactory = new FlowDefintitionFactory();
        flowDefintitionFactory.initDefintionFactory();
        FlowContext flowContext = new FlowContext();
        flowContext.setFlowDefintitionMap(flowDefintitionFactory.flowDefintitionMap);
        return flowContext;
    }
}
