package neal.java.effectivejava._4classinterface;


import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Item 24: Favor static member classes over nonstatic
 */
public class _24 {
    /**
     * There are four kinds of nested
     * classes: static member classes, nonstatic member classes, anonymous classes,
     * and local classes. All but the first kind are known as inner classes
     */

    // Typical use of a nonstatic member class
    public abstract class MySet<E> extends AbstractSet<E> {
        // Bulk of the class omitted
        @Override
        public Iterator<E> iterator() {
            return new MyIterator();
        }

        private class MyIterator implements Iterator<E> {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        }
    }


    public void test() {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {

        }
    }


    public static void main(String[] args) {
        final int[] a = {1, 2};
        int[] b = {3,4};
        a[0] = 2;
       // a = b;
    }
}
