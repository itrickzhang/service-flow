package com.service.flow.support.yml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.service.flow.model.FlowDefintition;
import com.service.flow.model.Node;
import com.service.flow.support.FlowDefintionRegistry;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangcb
 * @ClassName YmlFlowDefintionRegistry.java
 * @Description 基于YML格式注册流程模型
 * @createTime 2020年06月21日 15:38:00
 */
public class YmlFlowDefintionRegistry implements FlowDefintionRegistry {

    private final String CLASSPATH_FLOW="flow/*.flow.yml";

    @Override
    public Map<String, FlowDefintition> registry() throws Exception{
        return registryModel();
    }

    /**
     * 注册流程模型
     * @return
     * @throws Exception
     */
    public Map<String, FlowDefintition> registryModel() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(CLASSPATH_FLOW);
        Map<String,FlowDefintition> flowMap = new HashMap<>();
        Arrays.stream(resources).forEach(resource->{
            YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
            yamlMapFactoryBean.setResources(resource);
            yamlMapFactoryBean.afterPropertiesSet();
            Map<String, Object> object = yamlMapFactoryBean.getObject();
            YmlFlow flow = JSONObject.parseObject(JSON.toJSONString(object), YmlFlow.class);
            flowMap.put(flow.getId(),buildFlowDefintition(flow));
        });
        return flowMap;
    }

    private FlowDefintition buildFlowDefintition(YmlFlow flow){
        FlowDefintition flowDefintition = new FlowDefintition();
        flowDefintition.setId(flow.getId());
        flowDefintition.setName(flow.getName());
        flowDefintition.setDesc(flow.getDesc());
        flowDefintition.setInput(flow.getInput());
        flowDefintition.setOutput(flow.getOutput());
        flowDefintition.setTemp(flow.getTemp());
        flowDefintition.setStartNode(flow.getStartNode());
        Map<String, Node> nodeMap = new HashMap<>();
        flow.getNodes().forEach(tempNode -> {
            Node node = tempNode.getNode();
            nodeMap.put(node.getId(),node);
        });
        flowDefintition.setNodeMap(nodeMap);
        return flowDefintition;
    }
}
