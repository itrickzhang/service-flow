package com.service.flow.parseing.component.method;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.component.AbstractNodeComponent;
import com.service.flow.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangcb
 * @ClassName MethodComponent.java
 * @Description 方法节点解析
 * @createTime 2020年06月19日 08:15:00
 */
public class MethodNodeComponent extends AbstractNodeComponent {

    private Logger logger = LoggerFactory.getLogger(MethodNodeComponent.class);

    @Override
    public BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp) {
        logger.debug("Start execution method node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        BaseInput initInput = initInput(node.getInput(), baseInput);
        String component = node.getComponent();
        String[] split = component.split(FlowConstants.COLON);
        BaseOutput baseOutput = (BaseOutput)ClassUtil.methodInvoke(split[0],split[1],initInput);
        logger.debug("End of execution method node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        return baseOutput;
    }


}
