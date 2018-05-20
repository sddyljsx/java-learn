package neal.java;

public class TestFinal {

    public static void main(String[] args) throws Exception {
        final int a = 1;
        //a=2;
        class test {
            int b;
            final int c;

            public test(int b, int c) {
                this.b = b;
                this.c = c;
            }

            public int getB() {
                return b;
            }

            public void setB(int b) {
                this.b = b;
            }

            public int getC() {
                return c;
            }

//            public int setC(int c) {
//                return this.c = c;
//            }


        }
        test b = new test(1, 2);
        b.b = 1;
        final test c = b;
        // c = new test();
        System.out.println(c.b);
        b.b = 3;
        System.out.println(c.b);
        System.out.println(b.c);
        // b.c = 3;
    }

}
