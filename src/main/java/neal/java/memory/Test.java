package neal.java.memory;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main_0(String[] args) throws Exception {

        System.out.println("test gc");
        String base = "test";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
            Thread.sleep(2000);
        }
    }

    public static void main_1(String[] args) throws Exception {

        System.out.println("test gc");
        String base = "test";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base;
            base = str;
            list.add(str.intern());
            Thread.sleep(2000);
        }
    }

    public static void main_2(String[] args) throws Exception {

        System.out.println("test gc");
        String base = "test";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + i;
            list.add(str.intern());
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws Exception {
        String s0 = "1";
        String s1 = new String("1");
        String s2 = new String("1").intern();
        System.out.println(s0 == s1);
        System.out.println(s0.equals(s1));
        System.out.println(s0 == s2);
        System.out.println(s0.equals(s2));

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 500000; i++) {
            list.add(new String(s0 + 1).intern());
        }

        for (int i = 0; i < 500000; i++) {
            list.add(new String(s0 + 1));
        }
        while (true) ;


//        System.out.println("test gc");
//        String base = "test";
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            //String str = base;
//            //System.out.println(str);
//            list.add(base);
//            Thread.sleep(10);
//        }
    }


}
