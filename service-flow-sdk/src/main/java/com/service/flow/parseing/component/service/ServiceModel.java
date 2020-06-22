package com.service.flow.parseing.component.service;

import com.service.flow.model.BaseInput;

/**
 * @author zhangcb
 * @ClassName ServiceModel.java
 * @Description TODO
 * @createTime 2020年06月21日 12:05:00
 */
public class ServiceModel {

    private String applicationName;

    private String uri;

    private String requestType;

    private BaseInput baseInput;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public BaseInput getBaseInput() {
        return baseInput;
    }

    public void setBaseInput(BaseInput baseInput) {
        this.baseInput = baseInput;
    }
}
