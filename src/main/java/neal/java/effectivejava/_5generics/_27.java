package neal.java.effectivejava._5generics;

import java.util.Arrays;

/**
 * Item 27: Eliminate unchecked warnings
 */
public class _27 {

    int size = 10;
    Object[] elements = new Object[10];

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
    public static void main(String[] args) {

    }
}
