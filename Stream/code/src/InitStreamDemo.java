import entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 * 创建流
 **/
public class InitStreamDemo {

    public static void main(String[] args) {

        // 通过集合获取流
        List<Employee> employeeData = getEmployeeData();
        Stream<Employee> employeeStream = employeeData.stream();

        // 通过数据获取流
        int[] arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);

        // 通过stream的of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 7);





    }

    public static List<Employee>  getEmployeeData(){
        List<Employee> list = new ArrayList<Employee>();
        for(int i=0;i<10;i++){
            list.add(new Employee("cjc"+i,i));
        }
        // 添加重复数据
        list.add(new Employee("cjc1",1));
        return list;
    }

}
