package neal.java.effectivejava._7lamdastream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

import static java.util.Comparator.comparingInt;

/**
 * Item	42:	Prefer	lambdas	to	anonymous	classes
 */
public class _42 {

    //	Enum	with	function	object	fields	&	constant-specific	behavior
    public enum Operation {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        TIMES("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);
        private final String symbol;
        private final DoubleBinaryOperator op;

        Operation(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("ad");
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Collections.sort(words, comparingInt(String::length));
        words.sort(comparingInt(String::length));
    }
}
