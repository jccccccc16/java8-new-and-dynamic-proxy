package com.cjc;

/**
 * 静态代理:
 * 特点：
 *  在编译期间代理类和被代理类都被确定下来了
 * User: cjc
 **/
public class StaticProxyDemo {
    public static void main(String[] args) {
        ClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.product();
    }

}


interface ClothFactory{

    void product();

}
// 代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory factory){
        this.clothFactory = factory;
    }

    @Override
    public void product() {
        System.out.println("被代理了");
        clothFactory.product();
        System.out.println("被代理了做了一些个的操作");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void product() {
        System.out.println("我是nike");
    }
}

