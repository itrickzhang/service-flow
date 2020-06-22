package com.service.flow.parseing.component;

import com.service.flow.model.BaseInput;
import com.service.flow.model.BaseOutput;
import com.service.flow.model.BaseTemp;
import com.service.flow.model.Node;

import java.util.Map;

/**
 * @author zhangcb
 * @ClassName NodeParser.java
 * @Description TODO
 * @createTime 2020年06月19日 08:16:00
 */
public interface NodeParser {

    BaseOutput parserNode(Node node, BaseInput baseInput, BaseTemp baseTemp);

    BaseOutput parser(Node node, BaseInput baseInput, BaseTemp baseTemp);

    void setNodeMap(Map<String, Node> nodeMap);

}
