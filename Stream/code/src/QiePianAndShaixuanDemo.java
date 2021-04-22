import entity.Employee;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 * 切片与帅选
 **/
public class QiePianAndShaixuanDemo {
    public static void main(String[] args) {

        System.out.println("*------------遍历全部");
        List<Employee> employeeData =
                InitStreamDemo.getEmployeeData();
        Stream<Employee> stream4 = employeeData.stream();
        stream4.forEach(System.out::println);

        System.out.println("*------------过滤");
        Stream<Employee> stream = employeeData.stream();
        stream.filter(employee -> employee.getAge()>5).forEach(System.out::println);


        System.out.println("*------------切片");
        // 切片
        Stream<Employee> stream1 = employeeData.stream();
        stream1.limit(5).forEach(System.out::println);
        System.out.println("*------------切片");
        // 跳过
        Stream<Employee> stream2 = employeeData.stream();
        stream2.skip(5).forEach(System.out::println);

        // distinct() 筛选，通过流所生成元素的hashCode(),和equal（）方法判断是否重复，
        // 从而去除重复元素
        System.out.println("*------------distinct去重");
        Stream<Employee> stream3 = employeeData.stream();
        stream3.distinct().forEach(System.out::println);




    }
}
