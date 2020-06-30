package com.service.flow.sample.common.test1;

import com.service.flow.api.DTO;
import com.service.flow.model.BaseInput;

/**
 * @author zhangcb
 * @ClassName Test1Input.java
 * @Description TODO
 * @createTime 2020年06月25日 07:01:00
 */
@DTO
public class Test1Input extends BaseInput {
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
