package com.service.flow.parseing.component;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.util.ClassUtil;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName MethodComponent.java
 * @Description TODO
 * @createTime 2020年06月19日 08:15:00
 */
public abstract class AbstractNodeComponent implements NodeParser{

    public Map<String, Node> nodeMap;


    /**
     * 初始化参数
     * @param inputUrl
     * @param baseInput
     * @return
     */
    public BaseInput initInput(String inputUrl, BaseInput baseInput){
        BaseInput baseInputTarget = ClassUtil.newInstance(inputUrl, BaseInput.class);
        BeanUtils.copyProperties(baseInput,baseInputTarget);
        return baseInputTarget;
    }


    /**
     * 解析节点信息
     * @param node 节点信息
     * @param baseInput 请求参数
     * @param baseTemp 临时上下文
     * @return
     */
    public BaseOutput parserNode(Node node, BaseInput baseInput, BaseTemp baseTemp){
        baseTemp.setFlowRecord(baseTemp.getFlowRecord().append(FlowConstants.NODEKEY+FlowConstants.NODE+node.getId()));
        BaseOutput baseOutput = parser(node, baseInput, baseTemp);
        return baseOutput;
    };

    @Override
    public void setNodeMap(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }

    @Override
    public abstract BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp);

}
