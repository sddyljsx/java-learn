package neal.java.effectivejava._4classinterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Item 15: Minimize the accessibility of classes and
 * members
 */
public class _15 {

    private static final Integer[] PRIVATE_VALUES = {1, 2, 3, 4, 5, 6};
    public static final List<Integer> VALUES =
            Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static final Integer[] values() {
        return PRIVATE_VALUES.clone();
    }

    public void test() {
        PRIVATE_VALUES[3] = 9;
    }


}
