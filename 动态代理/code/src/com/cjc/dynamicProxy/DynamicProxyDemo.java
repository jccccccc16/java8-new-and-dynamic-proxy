package com.cjc.dynamicProxy;

import com.sun.xml.internal.ws.runtime.config.TubelineFeature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * User: cjc
 **/
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Human superMan = new SuperMan();
        Human superManProxy = (Human) ProxyFactory.getProxyInstance(superMan);
//        String belief = superManProxy.getBelief();
//        System.out.println(belief);
        superManProxy.eat();
    }
}

interface Human{
    String getBelief();
    void eat();
}

class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "我是超人";
    }

    @Override
    public void eat() {
        System.out.println("我爱吃草");
    }
}

class ProxyFactory{



    /**
     * 动态获取代理对象
     * @param object 被代理对象
     * @return
     */
    public static Object getProxyInstance(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);
        Object o = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), myInvocationHandler);
        return o;
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public void bind(Object object){
        this.object = object;
    }


    /**
     * 当我们调用某方法时
     * 如何代理
     * 也就是如何去增强被代理类的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        System.out.println("我在上面");
        Object reutrnValue = method.invoke(object,args);
        System.out.println("我在下面");
        return reutrnValue;
    }
}
