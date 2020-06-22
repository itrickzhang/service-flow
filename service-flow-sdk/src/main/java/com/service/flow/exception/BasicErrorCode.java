package com.service.flow.exception;

/**
 * @author zhangcb
 * @ClassName BasicErrorCode.java
 * @Description TODO
 * @createTime 2020年06月21日 19:45:00
 */
public enum BasicErrorCode implements ErrorCodeI {

    BIZ_ERROR("BIZ_ERROR" , "通用的业务逻辑错误"),

    FLOW_ERROR("FLOW_ERROR" , "框架错误"),

    SYS_ERROR("SYS_ERROR" , "未知的系统错误" );

    private String errCode;

    private String errDesc;

    private BasicErrorCode(String errCode, String errDesc){
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrDesc() {
        return errDesc;
    }
}
