package neal.java.serviceloader;

import java.util.ServiceLoader;

public class Loader {

    public static void main(String[] args) {

        System.out.println("load service...");
        ServiceLoader<IService> serviceLoader  = ServiceLoader.load(IService.class);
        System.out.println(serviceLoader.toString());

        // lazy load
        for(IService service : serviceLoader) {

            System.out.println(service.getSchema()+"="+service.sayHello());

        }

    }

}
