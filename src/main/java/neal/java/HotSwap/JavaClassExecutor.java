package neal.java.HotSwap;

import java.io.InputStream;
import java.lang.reflect.Method;

public class JavaClassExecutor {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classByte);
        byte[] modiBytes = classModifier.modifyUTF8Constant("java/lang/System", "neal/java/HotSwap/HackSystem");
        HotSwapClassLoader hotSwapClassLoader = new HotSwapClassLoader();
        Class clazz = hotSwapClassLoader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("echo", new Class[]{String[].class});
            method.invoke(null, new String[]{null});

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }

    public void test() {
        try {


            InputStream is = getClass().getResourceAsStream("JavaClassExecutor.class");
            byte[] b = new byte[is.available()];
            is.read(b);
            String result = execute(b);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void echo(String[] args){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new JavaClassExecutor().test();
    }
}
