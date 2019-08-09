package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/7 10:39
 * @throws
 */
@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    /**
     * 关键字 @Primary、@Querlifier用于消除@Autowired的歧义性
     * @Autowired 自动装载，会根据类型（by type）/名称(by var name)自动获取对应的Bean。
     * 如果该类型是一个接口，又有多个类实现了该接口，则根据@Autowired根据接口类型获取Bean时，有多个候选项，
     * 存在歧义性，引发异常。 简单的解决方法是通过变量名区分，但是这样代码失去一定灵活性。
     * @Primary 表示优先级，与@Component同时使用，有@Primary注解的Bean在遇到@Autowired歧义时，被优先选取。
     * 但是@Primary可同时用于多个Bean，又会引发歧义性，未根本解决歧义的问题
     * @Querlifier 关键字的value通过一个字符串定义要获取的Bean名称，与@Autowired同时使用。
     * 这样，@Autowired获取Bean的顺序是：
     * 先看前后行存在@@Querlifier关键字没有，如果有，@Querlifier内的value值为最优先级，解决存在多个@Primary候选Bean
     * 再看@Primary，它定义的Bean优先被获取
     * 最后再看可候选的Bean，如果还存在多个，则产生歧义异常
     * //    @Autowired
     * //    @Qualifier(value="dog")
     */
    private Animal animal = null;

    /**
     * 带有参数的构造方法类的装配
     * 1. 先删除存在@Autowired注解的方法或属性的@Autowired注解
     * 2. 在参数上加上@Autowired @Qualifier注解，使得参数能够注入进来（能注入到IoC容器被IoC容器使用生成Bean）。
     * @Qualifier 注解为了防止歧义，存在歧义的风险时才有必要加
     *
     */
    /**
    public BusinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }
     */

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    /**
     * Bean的生命周期（Spring IoC初始化和销毁Bean的过程）
     * 0. 先捋顺Bean如何装配到IoC容器中
     * 1. 资源定位
     * 通过配置：@ComponentScan定义的扫描路径去找带有@Component的类
     * 2. 解析资源，将定义的信息保存起来。此时尚未初始化，也没有Bean实例，有的仅仅是Bean定义
     * 3. 将Bean发布到IoC容器中，此时仍只有定义，没有被实例化
     * 上述完成资源定位，Bean定义发布到IoC容器，没有生成Bean的实例，更没有完成依赖注入
     * 默认情况下，Spring会继续完成Bean的实例化和依赖注入，但是有时我们想：
     * 只在我们需要取出Bean时，才去实例化和完成依赖注入，不需要时，只在IoC容器中保留Bean的定义，不做实例化和依赖注入
     * 4. 生命周期（见SpringBoot深入浅出2.x，P39）
     *
     */


    @Override
    public void setBeanName(String beanName) {
        System.out.println("【" + this.getClass().getSimpleName()
                            + "】调用BeanNameAware的setBeanName");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用BeanFactoryAware的setBeanFactory");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用ApplicationContextAware的setApplicationContext");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用InitializingBean的afterPropertiesSet方法");
    }
    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用@PostConstruct定义的自定义初始化方法");
    }
    @PreDestroy
    public void destory1() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用@PreDestroy定义的自定义销毁方法");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】DisposbleBean方法");
    }
}
