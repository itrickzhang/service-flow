# service-flow
微服务流程编排框架，支持方法节点、bean节点、条件节点（循环节点）、服务节点、子流程节点

# 快速入门
## 依赖
版本按实际情况给定
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
      desc: 服务节点
      input: com.service.flow.sample.common.model.TestInput
      type: service
      next: node7
  - node:
      id: node7
      name: subFlow
      component: test2
      desc: 子流程节点
      input: com.service.flow.sample.common.model.TestInput
      type: subflow
```
## 执行结果
```
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : result:Test{name='zhangsan', age=18}
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : record:Flow:test2->Node:node1
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : totalTime:0ms
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : result:Test{name='zhangsan', age=18}
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : record:Flow:test->Node:node1->Node:node2->Node:node3->Node:node5->Node:node6->Node:node7
2020-06-22 22:43:30.607  INFO 7276 --- [           main] com.service.flow.web.api.FlowHandler     : totalTime:52ms

```
## 相关示例
* 方法节点:[/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test1.flow.yml](/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test1.flow.yml)
* bean节点:[/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test2.flow.yml](/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test2.flow.yml)
* 条件节点(循环节点):[/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test3.flow.yml](/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test3.flow.yml)
* 服务调用节点:[/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test4.flow.yml](/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test4.flow.yml)
* 子流程节点:[/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test5.flow.yml](/service-flow-sample/service-flow-sample-web1/src/main/resources/flow/test5.flow.yml)

---------------------------------------------------------------------------------------------------------
# 相关文章
* [实战项目：设计实现一个流程编排框架(分析)](https://mp.weixin.qq.com/s/veLQZJqYNKbYvuCi7Pf_nA)
* [实战项目：设计实现一个流程编排框架(设计)](https://mp.weixin.qq.com/s/vL_ExJci7eiym9aizChtAQ)
* [实战项目：设计实现一个流程编排框架(实现)](https://mp.weixin.qq.com/s/2MOWIZ4emkQltEgFzja4SA)
![wechat](/doc/wechat.jpg)
