package com.service.flow.index.component;

import com.service.flow.api.DTO;
import com.service.flow.api.Flow;
import com.service.flow.api.FlowTypeEnum;
import com.service.flow.exception.FlowException;
import com.service.flow.index.ReflectionsScan;
import com.service.flow.index.dto.DTODefinition;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangcb
 * @ClassName BaseComponentClassLoader.java
 * @Description TODO
 * @createTime 2020年06月29日 20:29:00
 */
public class BaseComponentClassLoader {

    private Map<String, ComponentDefinition> componentDefinitionMap;

    public BaseComponentClassLoader(){
        this.componentDefinitionMap = new HashMap<>();
    }

    public void load(String scanName) {
        // 扫包
        Reflections reflections = ReflectionsScan.scan(scanName);
        // 获取带有特定注解对应的方法
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Flow.class ) ;
        Iterator<Method> iterator = methods.iterator();
        while (iterator.hasNext()){
            Method method = iterator.next();
            Flow annotation = method.getAnnotation(Flow.class);
            String name = annotation.name();
            FlowTypeEnum type = annotation.type();
            String desc = annotation.desc();
            String methodName = method.getName();
            String className = method.getDeclaringClass().getName();
            ComponentDefinition componentDefinition = new ComponentDefinition();
            componentDefinition.setValue(name);
            componentDefinition.setClassName(className);
            componentDefinition.setMethodName(methodName);
            componentDefinition.setDesc(desc);
            if(componentDefinitionMap.containsKey(name)){
                throw new FlowException(name+"重复定义："+className+","+componentDefinitionMap.get(name).getClassName());
            }
            this.componentDefinitionMap.put(name,componentDefinition);
        }
    }

    public Map<String,ComponentDefinition> getComponentDefinitionMap(){
        return this.componentDefinitionMap;
    }
}
