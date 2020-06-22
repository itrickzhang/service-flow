package com.service.flow.parseing;

import com.service.flow.exception.FlowException;
import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.FlowDefintition;
import com.service.flow.support.FlowDefintitionFactory;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangcb
 * @ClassName FlowParserTest.java
 * @Description TODO
 * @createTime 2020年06月22日 21:49:00
 */
class FlowParserTest {

    @Test
    void execute() {
        FlowDefintitionFactory flowDefintitionFactory = new FlowDefintitionFactory();
        flowDefintitionFactory.initDefintionFactory();
        Map<String, FlowDefintition> flowDefintitionMap = flowDefintitionFactory.flowDefintitionMap;
        FlowDefintition defintition = flowDefintitionMap.get("test");

        BaseInput baseInput = new BaseInput();
        FlowParser flowParser = new FlowParser(defintition);
        BaseOutput execute = null;
        try{
            execute = flowParser.execute(baseInput);
        }catch (IOException e){
            throw new FlowException("Flow execution exception");
        }
    }
}