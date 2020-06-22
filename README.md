# service-flow
微服务流程编排框架，支持方法节点、bean节点、条件节点、服务节点、子流程节点

# 快速入门
## 依赖
版本按时间情况给定
```
<dependency>
    <groupId>com.service.flow</groupId>
    <artifactId>service-flow-spring-boot-starter</artifactId>
 </dependency>
```

## 定义输出参数DTO
需要继承BaseInput
```
public class TestInput extends BaseInput
```
## 定义输出参数DTO
需要继承BaseOutPut
```
public class TestOutput extends BaseOutput
```
## 定义流程临时变量
需要继承BaseTemp
```
public class TestTemp extends BaseTemp
```
## 定义组件
```
@Component("testComponent")
public class TestComponent {

     public TestOutput test1(TestInput test){
         TestOutput testOutput = new TestOutput();
         BeanUtils.copyProperties(test,testOutput);
         System.out.println("1111111111"+testOutput);
         return testOutput;
     }
......

}
```
# 流程定义
## 新增流程文件
在resources/flow下新建test.flow.yml
```
name: openAccount
id: test
desc: 条件执行
input: com.service.flow.sample.common.model.TestInput
output: com.service.flow.sample.common.model.TestOutput
temp: com.service.flow.sample.common.model.TestTemp
startNode: node1
nodes:
  - node:
      id: node1
      name: methodInvoke
      component: com.service.flow.sample.common.component.TestComponent:test1
      desc: 单节点执行
      input: com.service.flow.sample.common.model.TestInput
      type: method
      next: node2
  - node:
      id: node2
      name: beanInvoke
      component: testComponent:test2
      desc: 单节点执行
      input: com.service.flow.sample.common.model.TestInput
      type: bean
      next: node3
  - node:
      id: node3
      name: conditionByAge
      component: age>20:node4,age<20:node5
      desc: 条件节点执行
      type: condition
  - node:
      id: node4
      name: beanInvoke
      component: testComponent:test4
      desc: bean节点执行
      input: com.service.flow.sample.common.model.TestInput
      type: bean
  - node:
      id: node5
      name: beanInvoke
      component: testComponent:test5
      desc: bean节点执行
      input: com.service.flow.sample.common.model.TestInput
      type: bean
      next: node6
  - node:
      id: node6
      name: serviceInvoke
      component: /test:post:testApplication
      desc: 方法节点调用
      input: com.service.flow.sample.common.model.TestInput
      type: service
      next: node7
  - node:
        id: node7
        name: subFlow
        component: test2
        desc: 方法节点调用
        input: com.service.flow.sample.common.model.TestInput
        type: subflow
```
## 执行结果
```
2020-06-22 22:25:22.097  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : result:Test{name='zhangsan', age=18}
2020-06-22 22:25:22.097  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : record:Flow:test2->Nodenode1
2020-06-22 22:25:22.097  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : totalTime:0ms
2020-06-22 22:25:22.098  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : result:Test{name='zhangsan', age=18}
2020-06-22 22:25:22.098  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : record:Flow:test->Nodenode1->Nodenode2->Nodenode3->Nodenode5->Nodenode6->Nodenode7
2020-06-22 22:25:22.098  INFO 19044 --- [           main] com.service.flow.web.api.FlowHandler     : totalTime:54ms

```
了解更多
![wechat](https://github.com/itrickzhang/service-flow/blob/master/doc/wechat.jpg)
