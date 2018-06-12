package neal.java.effectivejava._5generics;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item	32:	Combine	generics	and	varargs	judiciously
 * Use	 @SafeVarargs	 on	 every	 method	 with	 a	 varargs	 parameter	 of	 a
 * generic	or	parameterized	type
 */
public class _32 {

    //	Mixing	generics	and	varargs	can	violate	type	safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = Lists.newArrayList(42);
        Object[] objects = stringLists;
        objects[0] = intList;    //	Heap	pollution
        String s = stringLists[0].get(0);    //	ClassCastException
    }

    //	UNSAFE	-	Exposes	a	reference	to	its	generic	parameter	array!
    @SafeVarargs
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                /**
                 it	 is	 unsafe	 to	 give
                 another	 method	 access	 to	 a	 generic	 varargs	 parameter	 array

                 * with	 two
                 exceptions:	it	is	safe	to	pass	the	array	to	another	varargs	method	that	is	correctly
                 annotated	with	@SafeVarargs,	and	it	is	safe	to	pass	the	array	to	a	non-varargs
                 method	that	merely	computes	some	function	of	the	contents	of	the	array
                 */
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();    //	Can't	get	here
    }

    //	Safe	method	with	a	generic	varargs	parameter
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    //	List	as	a	typesafe	alternative	to	a	generic	varargs	parameter
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"a"};
        //List<String>[] b = {new ArrayList<String>()};
        Object[] attributes2 = pickTwo("Good", "Fast", "Cheap");
        String[] attributes = pickTwo("Good", "Fast", "Cheap");

    }
}
