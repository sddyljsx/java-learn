package neal.java.zk;

import org.apache.zookeeper.KeeperException;

import java.util.List;

public class ZKListGroup extends ZKConnectionWatcher {
    public void list(String groupName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);
            if (children.isEmpty()) {
                System.out.printf("No members in group %s\n", groupName);
                System.exit(1);
            }
            for (String child : children) {
                System.out.println(child);
            }
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s does not exist\n", groupName);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws Exception {
        ZKListGroup listGroup = new ZKListGroup();
        listGroup.connect("localhost");
        listGroup.list("zk");
        listGroup.close();
    }
}
