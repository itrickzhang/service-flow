package com.service.flow.support;

import com.service.flow.exception.FlowException;
import com.service.flow.model.FlowDefintition;
import com.service.flow.support.yml.YmlFlowDefintionRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowDefintition.java
 * @Description 流程模型加载工厂
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowDefintitionFactory {

    public  static List<FlowDefintionRegistry> flowDefintionRegistries = new ArrayList<>();

    public static Map<String, FlowDefintition> flowDefintitionMap = new HashMap<>();

    static {
        flowDefintionRegistries.add(new YmlFlowDefintionRegistry());
    }

    /**
     * 初始化流程加载
     */
    public void initDefintionFactory() {
        flowDefintionRegistries.forEach(flowDefintionRegistry -> {
            try {
                flowDefintitionMap.putAll(flowDefintionRegistry.registry());
            } catch (Exception e) {
                throw new FlowException("Flow loading exception",e);
            }
        });
    }
}
