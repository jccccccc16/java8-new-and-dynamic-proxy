import entity.Employee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 * 收集流中的元素
 **/
public class CollectDemo {

    public static void main(String[] args) {
        List<Employee> employeeData =
                InitStreamDemo.getEmployeeData();
        Set<Employee> collect = employeeData.stream().filter(employee -> employee.getAge() > 5).collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

}
