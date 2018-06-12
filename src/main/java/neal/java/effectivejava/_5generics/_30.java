package neal.java.effectivejava._5generics;

import java.util.*;
import java.util.function.UnaryOperator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Item	30:	Favor	generic	methods
 */
public class _30 {

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }


    //	Generic	singleton	factory	pattern
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }


    //	Returns	max	value	in	a	collection	-	uses	recursive	type	bound
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty	collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }


    public static void main(String[] args) {
        /**
         *  public static <E> HashSet<E> newHashSet(E... elements) {
         HashSet<E> set = newHashSetWithExpectedSize(elements.length);
         Collections.addAll(set, elements);
         return set;
         }
         */
        Set<String> guys = Sets.newHashSet("Tom", "Dick", "Harry");
        Set<String> stooges = Sets.newHashSet("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);


        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }


        List<String> list = Lists.newArrayList("a", "b", "c");
        System.out.println(max(list));
    }
}
