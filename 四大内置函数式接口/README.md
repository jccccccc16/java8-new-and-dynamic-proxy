![在这里插入图片描述](https://img-blog.csdnimg.cn/2021042122333581.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)



### 消费性接口

有入没出

```java
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
```



### 供给型接口



```java
public class SupplerDemo {

    public static void main(String[] args) {
        Supplier<Woman> supplier = ()->new Woman("cjc");
        Woman instance = getInstance(supplier);
        System.out.println(instance);

    }

    public static Woman getInstance(Supplier<Woman> supplier){
        return supplier.get();
    }
}

class Woman{
    private String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}

```

