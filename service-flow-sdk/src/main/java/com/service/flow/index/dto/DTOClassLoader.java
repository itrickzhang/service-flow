package com.service.flow.index.dto;

import com.service.flow.api.DTO;
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

    public void load() {
        Reflections reflections = new Reflections("com.service");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(DTO.class);
        Iterator<Class<?>> iterator = typesAnnotatedWith.iterator();
        while (iterator.hasNext()){
            Class<?> clazz = iterator.next();
            DTO annotation = clazz.getAnnotation(DTO.class);
            String className = clazz.getName();
            String value = StringUtils.isEmpty(annotation.value())?className:annotation.value();;
            String desc = annotation.desc();
            DTODefinition dtoDefinition = new DTODefinition();
            dtoDefinition.setClassName(className);
            dtoDefinition.setValue(value);
            dtoDefinition.setDesc(desc);
            dtoDefinitionMap.put(value,dtoDefinition);
        }
    }

    public Map<String,DTODefinition> getDtoDefinitionMap(){
        return this.dtoDefinitionMap;
    }
}
