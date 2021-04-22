import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 **/
public class OptionDemo {

    public static void main(String[] args) {

        Boy boy = new Boy("cjc", null);
        String girlName = getGirlNameOptional(boy);
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
