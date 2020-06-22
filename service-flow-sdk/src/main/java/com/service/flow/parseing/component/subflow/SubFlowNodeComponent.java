package com.service.flow.parseing.component.subflow;

import com.service.flow.api.IFlowHandler;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.component.AbstractNodeComponent;
import com.service.flow.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangcb
 * @ClassName SubFlowNodeComponent.java
 * @Description 子流程节点解析
 * @createTime 2020年06月21日 15:38:00
 */
public class SubFlowNodeComponent extends AbstractNodeComponent {

    private Logger logger = LoggerFactory.getLogger(SubFlowNodeComponent.class);
    @Override
    public BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp) {
        logger.debug("Start execution subFlow node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        String component = node.getComponent();
        IFlowHandler flowHandler = SpringContextUtil.getBean(IFlowHandler.class);
        BaseOutput baseOutput = flowHandler.execute(component, baseInput);
        logger.debug("End of execution subFlow node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        return baseOutput;
    }
}
