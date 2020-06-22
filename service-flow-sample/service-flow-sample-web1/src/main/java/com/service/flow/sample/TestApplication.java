package com.service.flow.sample;

import com.service.flow.api.IFlowHandler;
import com.service.flow.sample.common.model.TestInput;
import com.service.flow.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        SpringApplication.run(TestApplication.class,args);
        test();
    }
    public static void test() throws IOException {
        TestInput input = new TestInput();
        input.setAge(18);
        input.setName("zhangsan");

        IFlowHandler flowHandler = SpringContextUtil.getBean(IFlowHandler.class);
        flowHandler.execute("test", input);
    }
}
