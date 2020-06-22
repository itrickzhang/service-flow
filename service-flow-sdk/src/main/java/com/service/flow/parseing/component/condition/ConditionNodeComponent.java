package com.service.flow.parseing.component.condition;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;
import com.service.flow.parseing.FlowParserHandler;
import com.service.flow.parseing.component.AbstractNodeComponent;
import com.service.flow.util.SpleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangcb
 * @ClassName ConditionNodeComponent.java
 * @Description 条件节点解析
 * @createTime 2020年06月19日 19:25:00
 */
public class ConditionNodeComponent extends AbstractNodeComponent {

    private Logger logger = LoggerFactory.getLogger(ConditionNodeComponent.class);

    @Override
    public BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp) {
        logger.debug("Start execution condition node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        String conditions = node.getComponent();
        String[] condition = conditions.split(FlowConstants.COMMA);
        AtomicReference<BaseOutput> output = new AtomicReference<>(new BaseOutput());
        Arrays.stream(condition).forEach(str->{
            String[] split1 = str.split(FlowConstants.COLON);
            Object eval = SpleUtils.eval(split1[0], baseTemp);
            if(Boolean.parseBoolean(eval.toString())){
                String nodeStr = split1[1];
                Node nodeByCondition = nodeMap.get(nodeStr);
                FlowParserHandler flowParserHandler = new FlowParserHandler();
                output.set(flowParserHandler.execNode(nodeByCondition, baseInput, baseTemp, nodeMap));
            }
        });
        logger.debug("End of execution condition node{NodeId:{},NodeName:{}}",node.getId(),node.getName());
        return output.get();
    }
}
