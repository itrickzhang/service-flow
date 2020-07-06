package com.service.flow.parseing;


import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.component.NodeComponentFactory;
import com.service.flow.parseing.component.NodeParser;
import com.service.flow.util.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowParserHandler.java
 * @Description 流程实行器
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowParserHandler {

    /**
     * 执行流程节点
     * @param node 节点信息
     * @param baseInput 输出参数
     * @param baseTemp 临时上下文
     * @param nodeMap 节点集合
     * @return 输出参数
     */
    public BaseOutput execNode(Node node, BaseInput baseInput, BaseTemp baseTemp, Map<String, Node> nodeMap){
        String type = node.getType();
        NodeParser nodeInstance = NodeComponentFactory.getNodeInstance(type);
        nodeInstance.setNodeMap(nodeMap);
        BaseOutput output = nodeInstance.parserNode(node, baseInput,baseTemp);
        BeanUtils.copyProperties(output,baseTemp);
        BeanUtils.copyProperties(baseTemp,baseInput);
        String nextNode = node.getNext();
        if(!StringUtils.isEmpty(nextNode)){
            Node nodeNext = nodeMap.get(nextNode);
            output = execNode(nodeNext,baseInput,baseTemp,nodeMap);
        }
        BeanUtils.copyProperties(baseTemp,output);
        return output;
    }

}
