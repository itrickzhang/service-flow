package com.service.flow.web.api;

import com.service.flow.api.IFlowHandler;
import com.service.flow.exception.FlowException;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.parseing.FlowParser;
import com.service.flow.web.config.FlowContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhangcb
 * @ClassName FlowApi.java
 * @Description TODO
 * @createTime 2020年06月21日 15:38:00
 */
@Component
public class FlowHandler implements IFlowHandler {

    private Logger logger = LoggerFactory.getLogger(FlowHandler.class);

    @Autowired
    private FlowContext flowContext;

    public BaseOutput execute(String flowId, BaseInput baseInput) {
        FlowParser flowParser = new FlowParser(flowContext.getFlowDefinition(flowId));
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


}
