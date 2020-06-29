package com.service.flow.index;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

/**
 * @author zhangcb
 * @ClassName ReflectionsScan.java
 * @Description TODO
 * @createTime 2020年06月29日 21:25:00
 */
public class ReflectionsScan {
    public static Reflections scan(String scanName){
        // 扫包
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(scanName) // 指定路径URL
                .addScanners(new SubTypesScanner()) // 添加子类扫描工具
                .addScanners(new FieldAnnotationsScanner()) // 添加 属性注解扫描工具
                .addScanners(new MethodAnnotationsScanner() ) // 添加 方法注解扫描工具
                .addScanners(new MethodParameterScanner() ) // 添加方法参数扫描工具
        );
        return reflections;
    }
}
