package com.service.flow.exception;

/**
 * @author zhangcb
 * @ClassName SysException.java
 * @Description TODO
 * @createTime 2020年06月21日 19:49:00
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = 4355163994767354840L;

    public SysException(String errMessage){
        super(errMessage);
        this.setErrCode(BasicErrorCode.SYS_ERROR);
    }

    public SysException(ErrorCodeI errCode, String errMessage) {
        super(errMessage);
        this.setErrCode(errCode);
    }

    public SysException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrorCode.SYS_ERROR);
    }

    public SysException(String errMessage, ErrorCodeI errorCode, Throwable e) {
        super(errMessage, e);
        this.setErrCode(errorCode);
    }
}
