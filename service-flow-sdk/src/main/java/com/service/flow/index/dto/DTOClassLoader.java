package com.service.flow.index.dto;

import com.service.flow.api.DTO;
import com.service.flow.exception.FlowException;
import com.service.flow.index.ReflectionsScan;
import org.reflections.Reflections;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangcb
 * @ClassName DTOClassLoader.java
 * @Description TODO
 * @createTime 2020年06月29日 07:21:00
 */
public class DTOClassLoader {

    private Map<String,DTODefinition> dtoDefinitionMap;

    public DTOClassLoader(){
        this.dtoDefinitionMap = new HashMap<>();
    }

    public void load(String scanName) {
        Reflections reflections = ReflectionsScan.scan(scanName);
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(DTO.class);
        Iterator<Class<?>> iterator = typesAnnotatedWith.iterator();
        while (iterator.hasNext()){
            Class<?> clazz = iterator.next();
            DTO annotation = clazz.getAnnotation(DTO.class);
            String simpleName = clazz.getSimpleName();
            String value = StringUtils.isEmpty(annotation.value())?simpleName:annotation.value();;
            String desc = annotation.desc();
            DTODefinition dtoDefinition = new DTODefinition();
            dtoDefinition.setClassName(clazz.getName());
            dtoDefinition.setValue(value);
            dtoDefinition.setDesc(desc);
            if(dtoDefinitionMap.containsKey(value)){
                throw new FlowException(value+"重复定义："+clazz.getName()+","+dtoDefinitionMap.get(value).getClassName());
            }
            dtoDefinitionMap.put(value,dtoDefinition);
        }
    }

    public Map<String,DTODefinition> getDtoDefinitionMap(){
        return this.dtoDefinitionMap;
    }
}
