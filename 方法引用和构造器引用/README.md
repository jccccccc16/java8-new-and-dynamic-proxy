### 方法引用与构造器引用

#### 方法引用

基于lambda表达式

对象/类::方法名

```java
public class MethodRefTestDemo {

    public static void main(String[] args) {

        Supplier<String> supplier = Man::getName;

        String s = supplier.get();
        System.out.println(s);

    }


}

class Man{


    public static String getName() {
        return "你好";
    }
}

```





特例：

一个函数式接口的方法有两个参数，在使用lambda表达式去调用其他类的方法来实现时，该对象方法只有一个参数，那么该对象作为函数式接口方法的第一个参数，该对象方法中的参数为第二个参数

comparatord的compare方法有两个参数:

而String 的compareTo有一个参数，

当调用comparator.compare("123", "1234")时，类似"123".compareTo("1234")

```java
Comparator<String> comparator =String::compareTo;
        int compare = comparator.compare("123", "1234");
        System.out.println(compare);
```

#### 构造器引用

```java
 public static void main(String[] args) {

        ManFactory manFactory = Man::new;
        Man man = manFactory.getInstance("cjc");
        
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
```



