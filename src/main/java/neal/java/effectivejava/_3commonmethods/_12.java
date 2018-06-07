package neal.java.effectivejava._3commonmethods;

/**
 * Item	12:	Always	override	toString
 */
public class _12 {
   static class Test {
        private int a;
        private String b;
        private Object c;

        @Override
        public String toString() {
            return "Test{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args){
        Test test = new Test();
        test.a=1;
        test.b="b";
        test.c=new Object();
        System.out.println(test);
    }

}