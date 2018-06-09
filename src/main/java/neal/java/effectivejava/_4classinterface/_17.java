package neal.java.effectivejava._4classinterface;

import java.math.BigInteger;
import java.util.BitSet;

/**
 * Item 17: Minimize mutability
 */
public class _17 {


    // Immutable complex number class
   static public final class Complex {
        private final double re;
        private final double im;

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public static Complex valueOf(double re, double im) {
            return new Complex(re, im);
        }

        public double realPart() {
            return re;
        }

        public double imaginaryPart() {
            return im;
        }

        public Complex plus(Complex c) {
            return new Complex(re + c.re, im + c.im);
        }

        public Complex minus(Complex c) {
            return new Complex(re - c.re, im - c.im);
        }

        public Complex times(Complex c) {
            return new Complex(re * c.re - im * c.im,
                    re * c.im + im * c.re);
        }

        public Complex dividedBy(Complex c) {
            double tmp = c.re * c.re + c.im * c.im;
            return new Complex((re * c.re + im * c.im) / tmp,
                    (im * c.re - re * c.im) / tmp);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Complex))
                return false;
            Complex c = (Complex) o;
// See page 47 to find out why we use compare instead of ==
            return Double.compare(c.re, re) == 0
                    && Double.compare(c.im, im) == 0;
        }

        @
                Override
        public int hashCode() {
            return 31 * Double.hashCode(re) + Double.hashCode(im);
        }

        @Override
        public String toString() {
            return "(" + re + " + " + im + "i)";
        }
    }

    public void test() {
        BigInteger bigInteger = new BigInteger("1");
        bigInteger = bigInteger.flipBit(1);

        BitSet bitSet = new BitSet();
        bitSet.flip(0);
    }

    public static BigInteger safeInstance(BigInteger val) {
        return val.getClass() == BigInteger.class ?
                val : new BigInteger(val.toByteArray());
    }

}