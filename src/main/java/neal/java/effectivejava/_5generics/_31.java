package neal.java.effectivejava._5generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Item	 31:	 Use	 bounded	 wildcards	 to	 increase	 API
 * flexibility
 */

/**
 * PECS	stands	for	producer-extends,	consumer-super.
 */
public class _31 {

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    //	Private	helper	method	for	wildcard	capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        /**
         *
         *
         * public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
         Iterator<? extends T> i = coll.iterator();
         T candidate = i.next();

         while (i.hasNext()) {
         T next = i.next();
         if (next.compareTo(candidate) > 0)
         candidate = next;
         }
         return candidate;
         }
         **/
        System.out.println(Collections.max(arrayList));
        /**
         *  @SuppressWarnings({"rawtypes", "unchecked"})
        public static void swap(List<?> list, int i, int j) {
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
        }
         */
        Collections.swap(arrayList, 0, 1);
    }
}
