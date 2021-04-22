

Stream提供了高效处理数据的方式

在java层面对数据做处理，Stream就是对集合数据处理

只操作数据，不存储数据

### 三个步骤

- 创建stream

- 中间操作

- 终止操作

  只有在终止执行，操作才会开始。比如foreach是一个终止操作

### 创建流

```java
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
        return list;
    }

```

### 3. 中间操作

#### 3.1 筛选与切片

过滤筛选

```java
public class QiePianAndShaixuanDemo {
    public static void main(String[] args) {
        List<Employee> employeeData =
                InitStreamDemo.getEmployeeData();
        Stream<Employee> stream = employeeData.stream();
        stream.filter(employee -> employee.getAge()>5).forEach(System.out::println);
    }
}

```

切片

遍历前5个元素

```java
Stream<Employee> stream1 = employeeData.stream();
        stream1.limit(5).forEach(System.out::println);
```

跳过

```java
// 跳过
        Stream<Employee> stream2 = employeeData.stream();
        stream2.skip(5).forEach(System.out::println);
```

去重

```java

        // distinct() 筛选，通过流所生成元素的hashCode(),和equal（）方法判断是否重复，
        // 从而去除重复元素
        System.out.println("*------------distinct去重");
        Stream<Employee> stream3 = employeeData.stream();
        stream3.distinct().forEach(System.out::println);
```

#### 3.2 映射

map中的函数型接口有返回值，那么会把经过操作的数据生成一个新的流

```java
public class MapDemo {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.stream().map(str->str.toUpperCase()).forEach(System.out::println);
    }


}
```

```java
public class MapDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.stream().map(str->getName).forEach(System.out::println);
    }


}
```





#### 3.3 排序

sort



#### 3.4 终止操作（如何用以处理的数据）

##### 3.4.1 匹配与查找

 allMatch(Predicate p) 检查是否匹配所有元素 

anyMatch(Predicate p) 检查是否至少匹配一个元素 

noneMatch(Predicate p) 检查是否没有匹配所有元素 

findFirst() 返回第一个元素 

findAny() 返回当前流中的任意元素 

##### 3.4.2 计算

 count() 返回流中元素总数 

max(Comparator c) 返回流中最大值 

min(Comparator c) 返回流中最小值 

forEach(Consumer c) 内部迭代(使用 

Collection 接口需要用户去做迭代， 称为外部迭代。相反，

Stream API 使用内部迭 代——它帮你把迭代做了) 



#### 3.5 归约

有一个自动累加操作

reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 T reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 Optional 

例子，计算集合中数的总和

```java
public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integerList.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
```

reduce方法

```java
T reduce(T identity, BinaryOperator<T> accumulator);
```

BinaryOperator方法，继承与BiFunction，是一个函数型接口

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> 
```



#### 3.6 收集

collect决定如何对流中元素的收集，比如收集到一个集合中

```java
public static void main(String[] args) {
        List<Employee> employeeData =
                InitStreamDemo.getEmployeeData();
        Set<Employee> collect = employeeData.stream().filter(employee -> employee.getAge() > 5).collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }
```





### 总结

map就是内置的函数型接口，foreach是消费型接口，filter就是断言型接口