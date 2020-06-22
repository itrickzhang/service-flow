package com.service.flow.support;

import com.service.flow.model.FlowDefintition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        Map<String, FlowDefintition> flowDefintitionMap = flowDefintitionFactory.flowDefintitionMap;
        Assert.assertEquals(true,flowDefintitionMap.containsKey("test"));
    }
}