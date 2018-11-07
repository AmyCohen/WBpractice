package MyBinaryTree;

import java.util.HashSet;
import java.util.Set;

public class MyBinaryTree {

    public static void main(String[] args) {
        MyBinaryTree tree1 = new MyBinaryTree();
        TreeNode n12 = new TreeNode(12);
        TreeNode n16 = new TreeNode(16);
        TreeNode n18 = new TreeNode(18);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode num12 = new TreeNode(12);
        TreeNode num18 = new TreeNode(18);


        tree1.root = n12;
        n12.left = n16;
        n12.right = n18;
        n16.left = n2;
        n16.right = n4;
        n18.left = n6;
        n18.right = n8;
        n2.left = num12;
        n2.right = num18;

//        System.out.println(leafCount(tree1));
//        System.out.println(tree1.treePathSum(36));
//        System.out.println("Sum of whole tree = " + tree1.treeSum());
//        System.out.println("Sprinkler total usage per minute = " + sprinklerSystem(tree1));
//        System.out.println("SubSet Sprinkler from junction on = " + tree1.subsetSprinklerSystem(tree1.root.left));
        System.out.println("Distinct Values = " + tree1.distinctValues());
    }
    public TreeNode root;


    /*
    Return the count of the leaves in a tree
     */
    public static int leafCount(MyBinaryTree tree) {
        return leafCountHelper(tree.root);
    }

    private static int leafCountHelper(TreeNode current) {

        if (current == null) {
            return 0;
        }
        if(current.left == null && current.right == null) {
            return 1;
        }
        return leafCountHelper(current.left) + leafCountHelper(current.right);
    }


    /*
    Given a binary tree and a sum, determine if the sum of values from the root to a leaf if equal to the sum.
     */


    public boolean treePathSum (int sum) {
        return sumFinder(this.root, sum);
    }

    private boolean sumFinder(TreeNode current, int sum) {

        if (current == null) {
            return false;
        }

        boolean answer = false;
        int subSum = sum-current.data;

        if (current.left == null && current.right == null && subSum == 0) {
            answer = true;
            return answer;
        }

        if (current.left != null) {
            answer = answer || sumFinder(current.left, subSum);
        }

        if (current.right != null) {
            answer = answer || sumFinder(current.right, subSum);
        }
        return answer;
    }



    /*
    Get the sum of the entire tree.
     */
    public int treeSum(){
        return treeSumHelper(this.root);
    }

    private int treeSumHelper (TreeNode current) {
        int subSum;

        if (current == null) {
            return 0;
        } else if (current.left == null && current.right == null) {
            return current.data;
        } else {
            subSum = current.data + treeSumHelper(current.left) + treeSumHelper(current.right);
        }

        return subSum;
    }


    /*
     Estimate water usage for a given sprinkler system
     */
    public static int sprinklerSystem (MyBinaryTree tree) {
        return waterUsage(tree.root);
    }

    private static int waterUsage(TreeNode current) {
        int total;

        if (current == null) {
            return 0;
        } else if (current.left == null && current.right == null) {
            return current.data;
        } else {
            total = current.data + waterUsage(current.left) + waterUsage(current.right);
        }

        return total;
    }

    /*
     Estimate water usage for a given sprinkler system starting from a particular node moving forward
     */

    public int subsetSprinklerSystem (TreeNode node) {
        return waterUsage(node);
    }

    private int partialWaterUsage(TreeNode current) {
        int total;

        if (current == null) {
            return 0;
        } else if (current.left == null && current.right == null) {
            return current.data;
        } else {
            total = current.data + partialWaterUsage(current.left) + partialWaterUsage(current.right);
        }

        return total;
    }


    Set<Integer> unique = new HashSet<>();

    public HashSet<Integer> distinctValues() {
        return distinctValueFinder(this.root);
    }

    private HashSet<Integer> distinctValueFinder(TreeNode current) {

        unique.add(current.data);

        if (current == null) {
            return null;
        }

        if (current.left == null && current.right == null) {
            return (HashSet<Integer>) unique;
        }

        if (current.left != null) {
            unique.add(current.left.data);
        }

        if (current.right != null) {
            unique.add(current.right.data);
        }

        distinctValueFinder(current.left);
        distinctValueFinder(current.right);

        return (HashSet<Integer>) unique;

    }







}


