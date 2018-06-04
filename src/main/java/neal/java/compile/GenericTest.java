package neal.java.compile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        System.out.println(map.get("a"));
    }

//    public void test(List<String> list){
//        System.out.println("invoke list string");
//    }
//
//    public void test(List<Integer> list){
//        System.out.println("invoke list integer");
//    }

//    public static String test(List<String> list) {
//        System.out.println("invoke list string");
//        return "";
//    }
//
//    public static int test(List<Integer> list) {
//        System.out.println("invoke list integer");
//        return 1;
//    }


}
