package com.service.flow.parseing.component.service;

import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.parseing.component.method.MethodNodeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @author zhangcb
 * @ClassName ServiceProxy.java
 * @Description TODO
 * @createTime 2020年06月21日 12:11:00
 */
public interface ServiceProxy {

   Logger logger = LoggerFactory.getLogger(ServiceProxy.class);

    default BaseOutput invoke(BaseInput baseInput){
        logger.info("Execute default service node,input:{}",baseInput);
        return new BaseOutput();
    }
}
