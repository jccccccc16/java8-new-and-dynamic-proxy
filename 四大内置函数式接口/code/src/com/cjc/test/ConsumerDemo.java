package com.cjc.test;

import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/21
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 **/
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<Integer> consumer = (money)->{
            System.out.println("你消费了"+money+"元");
        };

        Integer money = 10;

        ConsumerDemo.consume(money,consumer);

    }

    public static void consume(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

}
