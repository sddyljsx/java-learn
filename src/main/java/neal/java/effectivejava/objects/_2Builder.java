package neal.java.effectivejava.objects;


/**
 * Item	 2:	 Consider	 a	 builder	 when	 faced	 with	 many
 constructor	parameters

 * Builder
 */
public class _2Builder {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append("a").append("b").append(2);
        System.out.println(stringBuilder.toString());


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2).append("a").append("b").append(1);
        System.out.println(stringBuffer.toString());
    }

}
