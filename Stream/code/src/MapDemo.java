import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 * 映射
 **/
public class MapDemo {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.stream().map(str->str.toUpperCase()).forEach(System.out::println);
    }


}
