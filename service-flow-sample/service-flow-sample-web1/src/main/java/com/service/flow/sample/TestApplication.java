package com.service.flow.sample;

import com.service.flow.api.IFlowHandler;
import com.service.flow.sample.common.model.TestInput;
import com.service.flow.sample.common.test1.Test1Input;
import com.service.flow.sample.common.test2.Test2Input;
import com.service.flow.sample.common.test3.Test3Input;
import com.service.flow.util.SpringContextUtil;
import com.service.flow.web.api.AnnotationFlowHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * @author zhangcb
 * @ClassName TestApplication.java
 * @Description TODO
 * @createTime 2020年06月19日 08:00:00
 */
@SpringBootApplication(scanBasePackages = {"com.service.flow"})
public class TestApplication {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestApplication.class, args);
        //test1(applicationContext);
        //test2(applicationContext);
        //test3(applicationContext);
        //test4(applicationContext);
        //test5(applicationContext);
        test6(applicationContext);
    }

    private static void test6(ConfigurableApplicationContext applicationContext) {
        Test3Input input = new Test3Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(AnnotationFlowHandler.class);
        flowHandler.execute("test6", input);
    }

    private static void test5(ConfigurableApplicationContext applicationContext) {
        Test3Input input = new Test3Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(IFlowHandler.class);
        flowHandler.execute("test5", input);
    }

    private static void test4(ConfigurableApplicationContext applicationContext) {
        Test3Input input = new Test3Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(IFlowHandler.class);
        flowHandler.execute("test4", input);
    }

    private static void test3(ConfigurableApplicationContext applicationContext) {
        Test3Input input = new Test3Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(IFlowHandler.class);
        flowHandler.execute("test3", input);
    }


    public static void test1(ApplicationContext applicationContext){
        Test1Input input = new Test1Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(IFlowHandler.class);
        flowHandler.execute("test1", input);
    }

    private static void test2(ApplicationContext applicationContext) {
        Test2Input input = new Test2Input();
        input.setCount(0);
        IFlowHandler flowHandler = applicationContext.getBean(IFlowHandler.class);
        flowHandler.execute("test2", input);
    }

}
