package com.service.flow.util;


import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcb
 * @ClassName ClassUtils.java
 * @Description 类反射工具类
 * @createTime 2020年06月21日 15:38:00
 */
public class ClassUtil {

    /**
     * 创建新的实例对象
     * @param className 类名
     * @param expected 转换目标对象
     * @param params 请求参数
     * @param <E>
     * @return
     */
    public static <E> E newInstance(String className, Class<E> expected, Object... params) {
        Class<?> aClass = forName(className);
        return newInstance(aClass, expected, params);
    }

    /**
     * 根据类名映射类
     * @param className 类名
     * @return
     */
    public static Class<?> forName(String className) {
        try {
            return ClassUtils.forName(className, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * 创建新的实例对象
     * @param clazz 类名
     * @param expected 转换目标对象
     * @param params 请求参数
     * @param <E>
     * @return
     */
    public static <E> E newInstance(Class<?> clazz, Class<E> expected, Object... params) {
        if (expected != null && !expected.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(
                    "'" + clazz.getSimpleName() + "'" + "'must implements interface:'" + expected.getName() + "'");
        }
        if (params == null || params.length == 0) {
            try {
                return (E) clazz.newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            List<Class<?>> parameterTypes = getParamsType(params);
            try {
                return (E) clazz.getConstructor(parameterTypes.toArray(new Class<?>[0])).newInstance(params);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    /**
     * 获取参数列表
     * @param params
     * @return
     */
    public static List<Class<?>> getParamsType(@Nullable Object... params) {
        List<Class<?>> parameterTypes = new ArrayList<>();
        if (params != null && params.length > 0) {
            for (Object o : params) {
                parameterTypes.add(o.getClass());
            }

        }
        return parameterTypes;
    }

    /**
     * 根据类名获取方法的个数
     * @param className 类名
     * @param methodName 方法名
     * @return
     */
    public static int getMethodCountForMame(String className, String methodName) {
        Class<?> clazz = forName(className);
        return ClassUtils.getMethodCountForName(clazz, methodName);
    }

    /**
     * 判断是否有该方法
     * @param className 类名
     * @param methodName 方法名
     * @param paramTypes 参数
     * @return
     */
    public static boolean hasMethod(String className, String methodName, @Nullable Class<?>... paramTypes) {
        Class<?> clazz = forName(className);
        return ClassUtils.hasMethod(clazz, methodName, paramTypes);
    }

    /**
     * 方法调用
     * @param className 类名
     * @param methodName 方法名
     * @param params 参数
     * @param <T>
     * @return
     */
    public static <T> Object methodInvoke(String className, String methodName, @Nullable Object... params) {
        Class<?> clazz = forName(className);
        Object target;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException | IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
        return methodInvoke(target, methodName, params);
    }

    /**
     * 方法调用
     * @param target 类名
     * @param methodName 方法名
     * @param params 参数
     * @param <T>
     * @return
     */
    public static <T> Object methodInvoke(Object target, String methodName, @Nullable Object... params) {
        List<Class<?>> parameterTypes = getParamsType(params);
        Method method = ReflectionUtils.findMethod(target.getClass(), methodName,
                parameterTypes.toArray(new Class<?>[0]));
        Object ret = null;
        if (method == null) {
            throw new RuntimeException("方法不存在:" + methodName);
        }
        ret = ReflectionUtils.invokeMethod(method, target, params);
        return ret;
    }

}
