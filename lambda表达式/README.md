### 如果接口只有一个方法时，可以使用lambda表达式简化

比如，也就是说comparator，要实现comparator必须要重写compare这一个方法

```java
public class LambdaDemo {

    public static void main(String[] args) {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int num1 = (int)(o1);
                int num2 = (int)(o2);
                return num1>num2?1:0;
            }
        };
        
        



    }

}

```

既然只需实现一个方法，那么我们简约为这个样子

```java
Comparator comparator = (o1,o2) {
                int num1 = (int)(o1);
                int num2 = (int)(o2);
                return num1>num2?1:0;
            }
        };
```

```java
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

		// ::为方法引用
        Comparator<Integer> comparator3 = Integer::compare;

        int compare2 = comparator3.compare(1, 2);
        System.out.println(compare2);

    }
```



### 函数式接口

如果一个接口之声明了一个抽象方法，那么就称为函数式方法

比如runnable

### 练习

 调用 Collections.sort()方法，通过定制排序比较两个 Employee(先按 年龄比，年龄相同按姓名比),使用 Lambda 表达式作为参数传递。

```java
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
```

