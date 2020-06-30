package com.service.flow.sample.common.test1;


import com.service.flow.api.Flow;

/**
 * @author zhangcb
 * @ClassName Test1Component.java
 * @Description TODO
 * @createTime 2020年06月25日 07:03:00
 */
public class Test1Component {
    @Flow(name = "count")
    public Test1Output count(Test1Input input){
        Test1Output output = new Test1Output();
        int count = input.getCount();
        count++;
        output.setCount(count);
        return output;
    }
}
