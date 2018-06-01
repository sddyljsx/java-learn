package neal.java.jvm;

public class TryCatchFinally {

    public static int test() {
        int x;
        try {
            x = 1;
            System.out.println(x);
            // int a = 1/0;
            return x;
        } catch (Exception e) {
            x = 2;
            System.out.println(x);
            //int a = 1/0;
            return x;
        } finally {
            x = 3;
            //return x;
        }
    }

    public static void main(String[] args) {
        int result = test();
        System.out.println("return");
        System.out.println(result);
    }
}
