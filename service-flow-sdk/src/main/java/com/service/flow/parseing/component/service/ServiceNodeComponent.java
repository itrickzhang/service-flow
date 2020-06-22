package com.service.flow.parseing.component.service;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.component.AbstractNodeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangcb
 * @ClassName MethodComponent.java
 * @Description 服务节点解析
 * @createTime 2020年06月19日 08:15:00
 */
public class ServiceNodeComponent extends AbstractNodeComponent {

    private Logger logger = LoggerFactory.getLogger(ServiceNodeComponent.class);

    @Override
    public BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp) {
        logger.debug("Start execution service node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        String component = node.getComponent();
        String[] split = component.split(FlowConstants.COLON);
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setUri(split[0]);
        serviceModel.setRequestType(split[1]);
        serviceModel.setApplicationName(split[1]);
        ServiceProxy serviceProxy =new SampleServiceProxy(serviceModel);
        logger.debug("End of execution service node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        return serviceProxy.invoke(baseInput);
    }

}
