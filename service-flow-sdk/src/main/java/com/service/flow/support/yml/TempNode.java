package com.service.flow.support.yml;

import com.service.flow.model.Node;

/**
 * @author zhangcb
 * @ClassName TempNode.java
 * @Description 对应uml格式的临时模型
 * @createTime 2020年06月21日 15:38:00
 */
public class TempNode {

    private Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "TempNode{" +
                "node=" + node +
                '}';
    }
}
