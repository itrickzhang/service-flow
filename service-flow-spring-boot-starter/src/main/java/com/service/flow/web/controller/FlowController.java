package com.service.flow.web.controller;

import com.service.flow.model.FlowDefintion;
import com.service.flow.web.context.FlowContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowController.java
 * @Description TODO
 * @createTime 2020年06月22日 07:13:00
 */
@RestController
@RequestMapping("/flows")
public class FlowController {

    @Autowired
    private FlowContext flowContext;

    @GetMapping
    public Map<String, FlowDefintion> getAllFlows(){
       return flowContext.getFlowDefintitionMap();
    }
}
