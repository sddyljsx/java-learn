package neal.java.spark;

import java.util.ArrayList;

public class Tree extends ArrayList<Tree> {

    public static void main(String[] args){
        Tree tree = new Tree();
        Tree tree1 = new Tree();
        tree1.add(new Tree());
        tree.add(tree1);
        System.out.print(tree.size());
    }
}
