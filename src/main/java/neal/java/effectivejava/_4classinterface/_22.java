package neal.java.effectivejava._4classinterface;


/**
 * Item 22: Use interfaces only to define types
 */
public class _22 {

    // Constant utility class
    public class PhysicalConstants {
        private PhysicalConstants() { } // Prevents instantiation
        public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
        public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
        public static final double ELECTRON_MASS = 9.109_383_56e-31;
    }
}
