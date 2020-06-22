package com.service.flow.parseing.component.bean;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.component.AbstractNodeComponent;
import com.service.flow.util.ClassUtil;
import com.service.flow.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangcb
 * @ClassName MethodComponent.java
 * @Description bean节点解析
 * @createTime 2020年06月19日 08:15:00
 */
public class BeanNodeComponent extends AbstractNodeComponent {

    private Logger logger = LoggerFactory.getLogger(BeanNodeComponent.class);

    @Override
    public BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp) {
        logger.debug("Start execution bean node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        BaseInput initInput = initInput(node.getInput(), baseInput);
        String component = node.getComponent();
        String[] split = component.split(FlowConstants.COLON);
        Object bean = SpringContextUtil.getBean(split[0]);
        String simpleName = bean.getClass().getName();
        BaseOutput baseOutput = (BaseOutput)ClassUtil.methodInvoke(simpleName,split[1],initInput);
        logger.debug("End of execution bean node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        return baseOutput;
    }
}
