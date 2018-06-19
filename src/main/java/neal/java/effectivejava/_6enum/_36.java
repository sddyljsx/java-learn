package neal.java.effectivejava._6enum;

import java.util.EnumSet;
import java.util.Set;

import static neal.java.effectivejava._6enum._36.Text.STYLE_BOLD;
import static neal.java.effectivejava._6enum._36.Text.STYLE_ITALIC;

/**
 * Item	36:	Use	EnumSet	instead	of	bit	fields
 */
public class _36 {

    //	Bit	field	enumeration	constants	-	OBSOLETE!
    static public class Text {
        public static final int STYLE_BOLD = 1 << 0;    //	1
        public static final int STYLE_ITALIC = 1 << 1;    //	2
        public static final int STYLE_UNDERLINE = 1 << 2;    //	4
        public static final int STYLE_STRIKETHROUGH = 1 << 3;    //	8

        //	Parameter	is	bitwise	OR	of	zero	or	more	STYLE_	constants
        public void applyStyles(int styles) {
        }
    }


    //	EnumSet	-	a	modern	replacement	for	bit	fields
    static public class Text2 {
        public enum Style2 {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

        //	Any	Set	could	be	passed	in,	but	EnumSet	is	clearly	best
        public void applyStyles(Set<Style2> styles) {
        }
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);

        Text2 text2 = new Text2();
        text2.applyStyles(EnumSet.of(Text2.Style2.BOLD, Text2.Style2.ITALIC));
    }
}
