package com.service.flow.api;

import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;

/**
 * @author zhangcb
 * @ClassName IFlowHandler.java
 * @Description TODO
 * @createTime 2020年06月22日 07:17:00
 */
public interface IFlowHandler {
    BaseOutput execute(String flowId, BaseInput baseInput);
}
