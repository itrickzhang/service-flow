package com.service.flow.sample.common.test2;

import com.service.flow.model.BaseOutput;

/**
 * @author zhangcb
 * @ClassName Test1Input.java
 * @Description TODO
 * @createTime 2020年06月25日 07:01:00
 */
public class Test2Output extends BaseOutput {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Test1Input{" +
                "count=" + count +
                '}';
    }
}
