package neal.java.effectivejava._4classinterface;

import java.time.Instant;

/**
 * Item 19: Design and document for inheritance or else
 * prohibit it
 */
public class _19 {

    static public class Super {
        // Broken - constructor invokes an overridable method
         Super() {
            overrideMe();
        }

        public void overrideMe() {
        }
    }


    static public final class Sub extends Super {
        // Blank final, set by constructor
        private final Instant instant;

        Sub() {
            instant = Instant.now();
        }

        // Overriding method invoked by superclass constructor
        @Override
        public void overrideMe() {
            System.out.println(instant);

        }

    }


    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }


}

