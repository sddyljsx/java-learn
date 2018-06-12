package neal.java.constantpool;

public class StringTest {

    public static void main(String[] args){
        System.out.println("abc"=="abc");
        System.out.println("abc".equals("abc"));

        String a = "def";
        String b= "def";
        StringBuilder sb = new StringBuilder();
        sb.append("d").append("e").append("f");
        String c = sb.toString();
        String d = c.intern();
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);

    }
}
