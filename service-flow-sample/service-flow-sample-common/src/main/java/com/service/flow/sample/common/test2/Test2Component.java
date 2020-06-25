package com.service.flow.sample.common.test2;


import org.springframework.stereotype.Component;

/**
 * @author zhangcb
 * @ClassName Test1Component.java
 * @Description TODO
 * @createTime 2020年06月25日 07:03:00
 */
@Component
public class Test2Component {

    public Test2Output count(Test2Input input){
        Test2Output output = new Test2Output();
        int count = input.getCount();
        count++;
        output.setCount(count);
        return output;
    }
}
