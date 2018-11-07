package MyBinaryTree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode (int value){
        this.data = value;
    }

    public String toString() {
        return "" + this.data;
    }
}
