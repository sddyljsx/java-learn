package neal.java.effectivejava;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.EnumSet;

public class _1StaticFactoryMethod {

    //EnumSet

    BigInteger bigInteger = BigInteger.valueOf(100);

    String[] stringArray = (String[]) Array.newInstance(String.class, 3);

    // BufferedReader br	=	Files.newBufferedReader(null);
}
