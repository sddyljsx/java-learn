package neal.java.serviceloader;

public class HDFSService implements IService {

    static {
        System.out.println("hdfs service init");
    }

    @Override

    public String sayHello() {

        return "Hello HDFSService";

    }

    @Override

    public String getSchema() {

        return "hdfs";

    }

}
