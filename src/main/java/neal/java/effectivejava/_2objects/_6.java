package neal.java.effectivejava._2objects;


/**
 * Item	6:	Avoid	creating	unnecessary	objects
 */
public class _6 {


    public static void main(String[] args) {

        String s = new String("bikini");    //	DON'T	DO	THIS!

        String ss = "bikini";


        Long sum = 0L; // use long not Long
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }


}
