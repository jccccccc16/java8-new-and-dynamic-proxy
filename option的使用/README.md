optional避免空指针异常，如果对象为空，那么提供另一个对象，相当于提供一个备胎

传统的方法去避免空指针异常

可能会导致要编写非常多的嵌套判断语句

```java
public class OptionDemo {

    public static void main(String[] args) {

        Boy boy = new Boy("cjc", null);
        String girlName = getGirlName(boy);
        System.out.println(girlName);

    }

    /**
     * 不使用option
     * 传统的方法可能对导致要编写很多的判断语句
     * @param boy
     * @return
     */
   static String getGirlName(Boy boy){
        if(boy!=null){
            Girl girl = boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }
        }
        return null;
   }

}

class Boy{
    private String name;
    private Girl girl;

    public Boy(String name, Girl girl) {
        this.name = name;
        this.girl = girl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", girl=" + girl +
                '}';
    }
}

class Girl{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}

```



使用optional，如果为空那么返回一个备胎

```java
   static String getGirlNameOptional(Boy b){
       // 创建option
       Optional<Boy> boyOptional = Optional.ofNullable(b);
       // 如果optional中的boy为空的话，那么返回参数中的boy对象
       Boy boy = boyOptional.orElse(new Boy("default_boy", new Girl("default_girl")));
       Girl g = boy.getGirl();
       Optional<Girl> girlOptional = Optional.ofNullable(g);
       Girl girl = girlOptional.orElse(new Girl("default_girl"));
       return girl.getName();
   }
```



