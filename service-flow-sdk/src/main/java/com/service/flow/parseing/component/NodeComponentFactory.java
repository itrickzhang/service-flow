package com.service.flow.parseing.component;

import com.service.flow.parseing.component.bean.BeanNodeComponent;
import com.service.flow.parseing.component.condition.ConditionNodeComponent;
import com.service.flow.parseing.component.method.MethodNodeComponent;
import com.service.flow.parseing.component.service.ServiceNodeComponent;
import com.service.flow.parseing.component.subflow.SubFlowNodeComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangcb
 * @ClassName NodeComponentFactory.java
 * @Description 节点解析工厂函数
 * @createTime 2020年06月19日 08:25:00
 */
public class NodeComponentFactory {

    private final static Map<String,NodeParser> cacheParser = new HashMap<>();

    static {
        cacheParser.put(NodeParserEnum.method.name(),new MethodNodeComponent());
        cacheParser.put(NodeParserEnum.bean.name(),new BeanNodeComponent());
        cacheParser.put(NodeParserEnum.condition.name(),new ConditionNodeComponent());
        cacheParser.put(NodeParserEnum.service.name(),new ServiceNodeComponent());
        cacheParser.put(NodeParserEnum.subflow.name(),new SubFlowNodeComponent());
    }

    public static NodeParser getNodeInstance(String nodeName){
        return cacheParser.get(nodeName);
    }
}
