package com.service.flow.parseing.component.service;

/**
 * @author zhangcb
 * @ClassName SampleServiceInvoke.java
 * @Description TODO
 * @createTime 2020年06月21日 12:14:00
 */
public class SampleServiceProxy implements ServiceProxy {

    private ServiceModel serviceModel;

    public SampleServiceProxy(ServiceModel serviceModel){
        this.serviceModel = serviceModel;
    }
}
