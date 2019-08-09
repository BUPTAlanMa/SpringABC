package com.springboot.chapter3.scope.pojo;

import org.springframework.stereotype.Component;

@Component
/**
 * 默认IoC的Bean是单例，每次获取的Bean是同一个
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 设置Bean的作用域是prototype原型，每次获取Bean生成一个新的Bean
 * @Scope(webApplicationContext.SCOPE_REQUEST)
 * 针对Spring Web应用，有四种作用域类型，session,application,request和page。对于page，Spring无法支持。
 * 对于request，Bean作用域是在web的单次请求中，
 * 对于application，在工程的生命周期中
 * 对于session, 作用域是HTTP会话
 */
public class ScopeBean {
}
