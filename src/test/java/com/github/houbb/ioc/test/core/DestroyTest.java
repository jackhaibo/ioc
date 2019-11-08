//package com.github.houbb.ioc.test.core;
//
//import com.github.houbb.heaven.util.guava.Guavas;
//import com.github.houbb.ioc.context.JsonApplicationContext;
//import com.github.houbb.ioc.core.BeanFactory;
//import com.github.houbb.ioc.model.BeanDefinition;
//import com.github.houbb.ioc.model.impl.DefaultBeanDefinition;
//import com.github.houbb.ioc.test.service.Apple;
//import com.github.houbb.json.bs.JsonBs;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author binbin.hou
// * @since 0.0.4
// */
//public class DestroyTest {
//
//    /**
//     * bean 工厂
//     * @since 0.0.2
//     */
//    private static final BeanFactory BEAN_FACTORY = new JsonApplicationContext("apple.json");
//
//    /**
//     * 测试
//     * @since 0.0.1
//     */
//    @Test
//    public void getBeanByNameTest() throws InterruptedException {
//        BeanFactory beanFactory = new JsonApplicationContext("apple.json");
//        Apple apple = (Apple) beanFactory.getBean("apple");
//
//        TimeUnit.SECONDS.sleep(60);
//
//        apple.color();
//    }
//
//    /**
//     * 测试
//     * @since 0.0.2
//     */
//    @Test
//    public void getBeanByNameTypeTest() {
//        Apple apple = BEAN_FACTORY.getBean("apple", Apple.class);
//        apple.color();
//    }
//
//    /**
//     * 测试
//     * @since 0.0.2
//     */
//    @Test
//    public void containsBeanTest() {
//        Assert.assertTrue(BEAN_FACTORY.containsBean("apple"));
//        Assert.assertFalse(BEAN_FACTORY.containsBean("box"));
//    }
//
//    /**
//     * 测试
//     * @since 0.0.2
//     */
//    @Test
//    public void isTypeMatchTest() {
//        Assert.assertTrue(BEAN_FACTORY.isTypeMatch("apple", Apple.class));
//        Assert.assertFalse(BEAN_FACTORY.isTypeMatch("apple", BeanFactory.class));
//    }
//
//    /**
//     * 单例测试
//     * @since 0.0.3
//     */
//    @Test
//    public void singletonTest() {
//        BeanFactory singleton = new JsonApplicationContext("singleton/apple-singleton.json");
//
//        Apple singletonOne = singleton.getBean("apple", Apple.class);
//        Apple singletonTwo = singleton.getBean("apple", Apple.class);
//        Assert.assertSame(singletonOne, singletonTwo);
//    }
//
//    /**
//     * 多例测试
//     * @since 0.0.3
//     */
//    @Test
//    public void prototypeTest() {
//        BeanFactory singleton = new JsonApplicationContext("singleton/apple-prototype.json");
//
//        Apple singletonOne = singleton.getBean("apple", Apple.class);
//        Apple singletonTwo = singleton.getBean("apple", Apple.class);
//        Assert.assertNotSame(singletonOne, singletonTwo);
//    }
//
//    /**
//     * 生成 apple json 测试
//     * @since 0.0.1
//     */
//    @Test
//    public void genAppleJsonTest() {
//        List<BeanDefinition> beanDefinitions = Guavas.newArrayList();
//        BeanDefinition apple = new DefaultBeanDefinition();
//        apple.setClassName("com.github.houbb.ioc.test.service.Apple");
//        apple.setName("apple");
//        beanDefinitions.add(apple);
//
//        System.out.println(JsonBs.serialize(beanDefinitions));
//    }
//
//}