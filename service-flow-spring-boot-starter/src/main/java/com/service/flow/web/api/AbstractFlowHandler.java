package com.service.flow.web.api;

import com.service.flow.api.IFlowHandler;
import com.service.flow.exception.FlowException;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.FlowDefintion;
import com.service.flow.parseing.FlowParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zhangcb
 * @ClassName AbstractFlowHandler.java
 * @Description TODO
 * @createTime 2020年06月30日 07:17:00
 */
public abstract class AbstractFlowHandler implements IFlowHandler {

    private Logger logger = LoggerFactory.getLogger(AbstractFlowHandler.class);

    @Override
    public BaseOutput execute(String flowId, BaseInput baseInput) {
        FlowParser flowParser = new FlowParser(flowDefintion(flowId));
        BaseOutput execute = null;
        try{
            execute = flowParser.execute(baseInput);
        }catch (IOException e){
            throw new FlowException("Flow execution exception");
        }
        logger.info("result:{}",execute);
        logger.info("record:{}",flowParser.getRecord());
        logger.info("totalTime:{}ms",flowParser.getTotalTime());
        return execute;
    }

    public abstract FlowDefintion flowDefintion(String flowId);
}
