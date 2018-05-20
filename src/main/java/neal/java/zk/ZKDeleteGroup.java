package neal.java.zk;

import org.apache.zookeeper.KeeperException;

import java.util.List;

public class ZKDeleteGroup extends ZKConnectionWatcher {
    public void delete(String groupName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);
            for (String child : children) {
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s does not exist\n", groupName);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws Exception {
        ZKDeleteGroup deleteGroup = new ZKDeleteGroup();
        deleteGroup.connect("localhost");
        deleteGroup.delete("zk");
        deleteGroup.close();
    }
}
