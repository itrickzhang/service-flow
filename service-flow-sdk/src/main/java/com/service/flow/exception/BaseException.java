package com.service.flow.exception;

/**
 * @author zhangcb
 * @ClassName BaseException.java
 * @Description TODO
 * @createTime 2020年06月21日 19:47:00
 */
public abstract class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ErrorCodeI errCode;

    public BaseException(String errMessage){
        super(errMessage);
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public ErrorCodeI getErrCode() {
        return errCode;
    }

    public void setErrCode(ErrorCodeI errCode) {
        this.errCode = errCode;
    }

}