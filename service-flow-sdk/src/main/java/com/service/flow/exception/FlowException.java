package com.service.flow.exception;

/**
 * @author zhangcb
 * @ClassName FlowException.java
 * @Description TODO
 * @createTime 2020年06月21日 19:47:00
 */
public class FlowException extends BaseException {

    private static final long serialVersionUID = 1L;

    public FlowException(String errMessage){
        super(errMessage);
        this.setErrCode(BasicErrorCode.FLOW_ERROR);
    }

    public FlowException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrorCode.FLOW_ERROR);
    }
}