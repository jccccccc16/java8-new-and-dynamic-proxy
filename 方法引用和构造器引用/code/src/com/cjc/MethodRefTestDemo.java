package com.cjc;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/21
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 **/
public class MethodRefTestDemo {

    public static void main(String[] args) {

        ManFactory manFactory = Man::new;
        Man man = manFactory.getInstance("cjc");
        Supplier<String> supplier = man::getName;

        String s = supplier.get();
        System.out.println(s);

        Comparator<String> comparator =String::compareTo;
        int compare = comparator.compare("123", "1234");
        System.out.println(compare);



    }


}

class Man {

    private String name;

    public Man(String name){
        this.name = name;
    }

    public  String getName() {
        return this.name;
    }

}

interface ManFactory{

    Man getInstance(String name);

}
