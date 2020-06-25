package com.service.flow.sample.common.test3;


import org.springframework.stereotype.Component;

/**
 * @author zhangcb
 * @ClassName Test1Component.java
 * @Description TODO
 * @createTime 2020年06月25日 07:03:00
 */
@Component
public class Test3Component {

    public Test3Output count(Test3Input input){
        Test3Output output = new Test3Output();
        int count = input.getCount();
        count++;
        output.setCount(count);
        return output;
    }

    public Test3Output count5(Test3Input input){
        Test3Output output = new Test3Output();
        int count = input.getCount();
        count = count +5;
        output.setCount(count);
        return output;
    }
}
