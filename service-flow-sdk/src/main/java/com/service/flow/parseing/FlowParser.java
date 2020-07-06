package com.service.flow.parseing;

import com.service.flow.constant.FlowConstants;
import com.service.flow.model.*;
import com.service.flow.util.BeanUtils;
import com.service.flow.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.Map;

/**
 * @author zhangcb
 * @ClassName FlowParster.java
 * @Description 流程加载执行
 * @createTime 2020年06月21日 15:38:00
 */
public class FlowParser {

    private Map<String, Node> nodeMap;

    private BaseTemp baseTemp;

    private FlowDefintion defintition;

    private String record;

    private Long totalTime;

    private Logger logger = LoggerFactory.getLogger(FlowParser.class);

    public FlowParser(FlowDefintion defintition){
       this.nodeMap = defintition.getNodeMap();
       this.defintition = defintition;
       this.baseTemp = ClassUtil.newInstance(defintition.getTemp(), BaseTemp.class);
    }

    /**
     * 执行流程
     * @param baseInput 请求参数
     * @return
     * @throws IOException
     */
    public BaseOutput execute(BaseInput baseInput) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuffer flowRecord = new StringBuffer();
        flowRecord.append(FlowConstants.FLOW+FlowConstants.COLON +defintition.getId());
        //输入参数
        BaseInput baseInputContext = ClassUtil.newInstance(defintition.getInput(), BaseInput.class);
        BeanUtils.copyProperties(baseInput,baseInputContext);
        BeanUtils.copyProperties(baseInputContext,baseTemp);
        baseTemp.setFlowRecord(flowRecord);
        BaseOutput baseOutput = ClassUtil.newInstance(defintition.getOutput(), BaseOutput.class);
        String startNode = defintition.getStartNode();
        Node node = defintition.getNodeMap().get(startNode);
        FlowParserHandler flowParserHandler = new FlowParserHandler();
        baseOutput = flowParserHandler.execNode(node,baseInputContext,baseTemp,nodeMap);
        stopWatch.stop();
        record = baseTemp.getFlowRecord().toString();
        totalTime = stopWatch.getTotalTimeMillis();
        //服务节点调用
        return baseOutput;
    }

    /**
     * 获取执行记录
     * @return
     */
    public String getRecord() {
        return record;
    }

    /**
     * 获取执行时间
     * @return
     */
    public Long getTotalTime() {
        return totalTime;
    }
}
