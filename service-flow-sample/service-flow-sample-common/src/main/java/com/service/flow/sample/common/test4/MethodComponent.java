package com.service.flow.sample.common.test4;

import com.service.flow.api.Flow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangcb
 * @ClassName MethodComponent.java
 * @Description TODO
 * @createTime 2020年07月06日 07:30:00
 */
public class MethodComponent {

    private Logger logger = LoggerFactory.getLogger(MethodComponent.class);

    @Flow(name = "refundApp")
    public RefundResponse refundApp(RefundRequest refundRequest){
        logger.info("执行退款申请");
        return new RefundResponse();
    }

    @Flow(name = "paramCheck")
    public RefundResponse paramCheck(RefundRequest refundRequest){
        logger.info("执行参数检查");
        return new RefundResponse();
    }

    @Flow(name = "configCheck")
    public RefundResponse configCheck(RefundRequest refundRequest){
        logger.info("检查退款的特殊配置");
        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setConfig("cache");
        return refundResponse;
    }

    @Flow(name = "routeChannel")
    public RefundResponse routeChannel(RefundRequest refundRequest){
        logger.info("路由通道");
        return new RefundResponse();
    }

    @Flow(name = "cacheRefundConfig")
    public RefundResponse cacheRefundConfig(RefundRequest refundRequest){
        logger.info("缓存退款配置");
        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setConfig("loop");
        return refundResponse;
    }

    @Flow(name = "loopRefundApp")
    public RefundResponse loopRefundApp(RefundRequest refundRequest){
        logger.info("轮询退款申请");
        return new RefundResponse();
    }

    @Flow(name = "noSupport")
    public RefundResponse noSupport(RefundRequest refundRequest){
        logger.info("不支持退款");
        return new RefundResponse();
    }

    @Flow(name = "packageChannel")
    public RefundResponse packageChannel(RefundRequest refundRequest){
        logger.info("组装报文通道");
        return new RefundResponse();
    }

    @Flow(name = "saveRefundInfo")
    public RefundResponse saveRefundInfo(RefundRequest refundRequest){
        logger.info("保存退款信息");
        return new RefundResponse();
    }

    @Flow(name = "packageSign")
    public RefundResponse packageSign(RefundRequest refundRequest){
        logger.info("报文签名");
        return new RefundResponse();
    }

    @Flow(name = "signature")
    public RefundResponse signature(RefundRequest refundRequest){
        logger.info("接受银行报文并验签");
        return new RefundResponse();
    }

    @Flow(name = "updateRefundInfo")
    public RefundResponse updateRefundInfo(RefundRequest refundRequest){
        logger.info("更新退款响应");
        return new RefundResponse();
    }

    @Flow(name = "returnRefund")
    public RefundResponse returnRefund(RefundRequest refundRequest){
        logger.info("返回退款响应");
        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setCode("200");
        refundResponse.setMessage("处理成功");
        return refundResponse;
    }
}
