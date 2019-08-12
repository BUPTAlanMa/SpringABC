package com.springboot.chapter4.intercept;

import com.springboot.chapter4.invoke.Invocation;
import java.lang.reflect.InvocationTargetException;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/9 17:34
 * @throws
 */
public interface Interceptor {
    // 事前方法
    public boolean before();

    // 事后方法
    public void after();

    /**
     * 取代原有事件方法
     * @param
     *
     */
    public Object around(Invocation invocation)
        throws InvocationTargetException, IllegalAccessException;

    // 是否返回方法，时间没有发生异常执行
    public void afterReturning();

    // 事后异常方法，当事件发生异常后执行
    public void afterThrowing();

    // 是否使用around方法取代原有方法
    boolean useAround();
}
