package neal.java.effectivejava._2objects;

import java.lang.reflect.Array;
import java.math.BigInteger;

/**
 *
 * Item	 1:	 Consider	 static	 factory	 methods	 instead	 of
 constructors

 * 静态工厂方法
 */
public class _1 {

    //EnumSet

    BigInteger bigInteger = BigInteger.valueOf(100);

    String[] stringArray = (String[]) Array.newInstance(String.class, 3);

    // BufferedReader br	=	Files.newBufferedReader(null);
}
