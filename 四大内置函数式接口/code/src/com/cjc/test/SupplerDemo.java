package com.cjc.test;

import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/21
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 **/
public class SupplerDemo {

    public static void main(String[] args) {
        Supplier<Woman> supplier = ()->new Woman("cjc");
        Woman instance = getInstance(supplier);
        System.out.println(instance);

    }

    public static Woman getInstance(Supplier<Woman> supplier){
        return supplier.get();
    }
}

class Woman{
    private String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}

