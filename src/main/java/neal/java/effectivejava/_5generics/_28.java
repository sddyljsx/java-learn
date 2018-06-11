package neal.java.effectivejava._5generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 28: Prefer lists to arrays
 */
public class _28 {

    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException


        // Won't compile!
        //List<Object> ol = new ArrayList<Long>(); // Incompatible types
        //ol.add("I don't fit in");
    }

    // List-based Chooser - typesafe
    public class Chooser<T> {
        private final List<T> choiceList;

        public Chooser(Collection<T> choices) {
            choiceList = new ArrayList<>(choices);
        }

        public T choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceList.get(rnd.nextInt(choiceList.size()));
        }
    }
}
