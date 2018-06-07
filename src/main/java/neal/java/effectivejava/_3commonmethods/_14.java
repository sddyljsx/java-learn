package neal.java.effectivejava._3commonmethods;

import java.util.Comparator;

/**
 * Item	14:	Consider	implementing	Comparable
 */
public class _14 {

    //	Single-field	Comparable	with	object	reference	field
    public final class CaseInsensitiveString
            implements Comparable<CaseInsensitiveString> {
        private String s;

        public int compareTo(CaseInsensitiveString cis) {
            return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
        }
    }

    public class number implements Comparable<number> {
        private int a;
        private int b;
        private int c;

        Comparator<number> comparator = Comparator.comparingInt((number pn) -> pn.a)
                .thenComparingInt(pn -> pn.b)
                .thenComparingInt(pn -> pn.c);

        @Override
        public int compareTo(number o) {
            return comparator.compare(this,o);
        }
    }


}
