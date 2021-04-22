import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/22
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 **/
public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integerList.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
