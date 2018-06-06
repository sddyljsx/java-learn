package neal.java.serviceloader;

public class LocalService  implements IService {

    @Override

    public String sayHello() {

        return "Hello LocalService";

    }

    @Override

    public String getSchema() {

        return "local";

    }

}
