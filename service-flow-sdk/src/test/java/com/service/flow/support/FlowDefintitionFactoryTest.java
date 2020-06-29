package com.service.flow.support;

import com.service.flow.model.FlowDefintion;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowDefintitionFactoryTest.java
 * @Description TODO
 * @createTime 2020年06月22日 14:07:00
 */
class FlowDefintitionFactoryTest {

    @Test
    void initDefintionFactory() {
        FlowDefintitionFactory flowDefintitionFactory = new FlowDefintitionFactory();
        flowDefintitionFactory.initDefintionFactory();
        Map<String, FlowDefintion> flowDefintitionMap = flowDefintitionFactory.flowDefintitionMap;
        Assert.assertEquals(true,flowDefintitionMap.containsKey("test"));
    }
}