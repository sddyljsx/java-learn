package neal.java.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }


    static class DynamicProxy implements InvocationHandler {

        Object originalObject;

        Object bind(Object originalObject) {
            this.originalObject = originalObject;
            return Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), originalObject.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObject,args);
        }
    }

    public static void main(String[] args){
        IHello iHello = (IHello) new DynamicProxy().bind(new Hello());
        iHello.sayHello();
    }
}
