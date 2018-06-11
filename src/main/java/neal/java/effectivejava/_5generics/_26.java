package neal.java.effectivejava._5generics;


import java.util.*;

/**
 * Item 26: Don’t use raw types
 */
public class _26 {

    public static void main(String[] args) {
        List stamps = new ArrayList();
        stamps.add("a");
        stamps.add(1);

        stamps.get(0);


        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);

        // Legitimate use of raw type - instanceof operator
        if (strings instanceof List) { // Raw type
            List<?> ss = (List<?>) strings; // Wildcard type

        }


        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }




}
