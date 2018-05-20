package neal.java.zk;

import org.apache.zookeeper.*;

public class ZKJoinGroup extends ZKConnectionWatcher {

    public void join(String groupName, String memberName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Created " + createdPath);
    }

    public static void main(String[] args) throws Exception {
        ZKJoinGroup joinGroup = new ZKJoinGroup();
        joinGroup.connect("localhost");
        joinGroup.join("zk","01");
        // stay alive until process is killed or thread is interrupted
        Thread.sleep(Long.MAX_VALUE);
    }

}

