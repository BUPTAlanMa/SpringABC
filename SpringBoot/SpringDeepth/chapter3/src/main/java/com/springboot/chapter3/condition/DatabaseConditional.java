package com.springboot.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/7 10:28
 * @throws
 */
public class DatabaseConditional implements Condition {

    @Override
    /*
     *
     * @param context 条件上下文
     * @param
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("database.driverName") && env.containsProperty("database.url")
                && env.containsProperty("database.username") && env.containsProperty("database.password");
    }

}
