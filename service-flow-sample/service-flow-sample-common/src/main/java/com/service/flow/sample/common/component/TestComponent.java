package com.service.flow.sample.common.component;

import com.service.flow.model.BaseOutput;
import com.service.flow.sample.common.model.TestInput;
import com.service.flow.sample.common.model.TestOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author zhangcb
 * @ClassName TestComponent.java
 * @Description TODO
 * @createTime 2020年06月17日 17:06:00
 */
@Component("testComponent")
public class TestComponent {

     public TestOutput test1(TestInput test){
         TestOutput testOutput = new TestOutput();
         BeanUtils.copyProperties(test,testOutput);
         System.out.println("1111111111"+testOutput);
         return testOutput;
     }

    public BaseOutput test2(TestInput test){
        TestOutput testOutput = new TestOutput();
        BeanUtils.copyProperties(test,testOutput);
        testOutput.setAge(22);
        System.out.println("222222222222"+testOutput);
        return testOutput;
    }

    public BaseOutput test3(TestInput test){
        TestOutput testOutput = new TestOutput();
        BeanUtils.copyProperties(test,testOutput);
        testOutput.setAge(33);
        System.out.println("3333333333"+testOutput);
        return testOutput;
    }
    public BaseOutput test4(TestInput test){
        TestOutput testOutput = new TestOutput();
        BeanUtils.copyProperties(test,testOutput);
        testOutput.setAge(44);
        System.out.println("444444444444444"+testOutput);
        return testOutput;
    }
    public BaseOutput test5(TestInput test){
        TestOutput testOutput = new TestOutput();
        BeanUtils.copyProperties(test,testOutput);
        testOutput.setAge(55);
        System.out.println("555555555555"+testOutput);
        return testOutput;
    }

}
