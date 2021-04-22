package com.cjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/21
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 **/
public class Practice01Demo {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("cjc",20);
        Employee employee2 = new Employee("jcj",11);
        employees.add(employee1);
        employees.add(employee2);
        Comparator<Employee> comparator = (e1,e2)->{
            int age1 = e1.getAge();
            int age2 = e2.getAge();
            return Integer.compare(age1,age2);
        };
        Collections.sort(employees,comparator);
        System.out.println(employees);

    }


}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }




    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
