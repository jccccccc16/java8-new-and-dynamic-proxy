package com.cjc;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/21
 * Time: 19:09
 * To change this template u    public static void main(String[] args) {
 *
 *         Comparator comparator = new Comparator() {
 *             @Override
 *             public int compare(Object o1, Object o2) {
 *                 int num1 = (int)(o1);
 *                 int num2 = (int)(o2);
 *                 return num1>num2?-1:1;
 *             }
 *         };
 *
 *         Comparator comparator2 = (o1,o2)->{
 *             int num1 = (int)(o1);
 *             int num2 = (int)(o2);
 *             return num1>num2?-1:1;
 *         };
 *
 *         int compare = comparator.compare(1, 2);
 *         int compare1 = comparator2.compare(1, 2);
 *         System.out.println(compare);
 *         System.out.println(compare1);
 *
 *
 *         Comparator<Integer> comparator3 = Integer::compare;
 *
 *         int compare2 = comparator3.compare(1, 2);
 *         System.out.println(compare2);
 *
 *     }se File | Settings | File Templates.
 **/
public class LambdaDemo {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        // 只有一条语句时可以将大括号省略
        Comparator<Integer> comparator2 = (o1,o2)-> Integer.compare(o1,o2);


        int compare = comparator.compare(1, 2);
        int compare1 = comparator2.compare(1, 2);
        System.out.println(compare);
        System.out.println(compare1);


        Comparator<Integer> comparator3 = Integer::compare;

        int compare2 = comparator3.compare(1, 2);
        System.out.println(compare2);



    }

}


interface  MyInterface{
    void eat(String food);
    void fly();
}
