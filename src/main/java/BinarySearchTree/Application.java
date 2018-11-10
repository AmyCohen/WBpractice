package BinarySearchTree;

public class Application {

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(15, "Fifteen");
        tree.insert(12, "Twelve");
        tree.insert(9, "Nine");
        tree.insert(2, "Two");
        tree.insert(30, "Thirty");
        tree.insert(6, "Six");

        System.out.println("Find Min: " + tree.findMin().key);
        System.out.println("Find Max: " + tree.findMax().key);


//        System.out.println("Remove Node: " + tree.remove(2)); //should print true;
//        System.out.println("New Min: " + tree.findMin().key); //15
//
//        System.out.println("Display Tree: ");
//        System.out.println(tree.displayTree());
//
//        System.out.println("Print out leaves: ");
//        System.out.println(tree.findLeaves(tree.findRoot()));


        tree.breadthFirstPrinting();
    }


}
