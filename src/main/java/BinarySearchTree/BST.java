package BinarySearchTree;

//PRACTICE FROM UDEMY

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private Node root;

    public Node findRoot(){
        return root;
    }

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {

            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if(key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }


        }
    }

    public Node findMin() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean remove(int key) {

        Node currentNode = root;
        Node parentNode = root;

        boolean isLeftChild = false;


        //Searching to find the node with the key to delete
        while (currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }

            if (currentNode == null) {
                return false;
            }
        }

        //found the node we want to delete
        Node nodeToDelete = currentNode;

        //if node is a leaf node
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }

        //if node has one child that is on the left
        } else if (nodeToDelete.rightChild == null) {
            if(nodeToDelete == root) {
                root = nodeToDelete.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToDelete.leftChild;
            } else {
                parentNode.rightChild = nodeToDelete.leftChild;
            }

        //if node has one child that is on the right
        } else if (nodeToDelete.leftChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = nodeToDelete.rightChild;
            } else {
                parentNode.rightChild = nodeToDelete.rightChild;
            }

        //if node has two children (tricky!)
        //find the smallest node from the set of LARGER
            //nodes from the one to be deleted
        } else {

            Node successor = getSuccessor(nodeToDelete);

            //connect parent of the nodeToDelete to
            //successor instead.
            if (nodeToDelete == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.leftChild = successor;
            } else {
                parentNode.rightChild = successor;
            }
            //this does the actual replacement
            successor.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
            Node successorParent = nodeToDelete;
            Node successor = nodeToDelete;

            //go to the right child
            Node current = nodeToDelete.rightChild;

            //start going left down the tree
            //until node has no left child
            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }
            //if successory is NOT a right child
            if (successor != nodeToDelete.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = nodeToDelete.rightChild;
            }
            return successor;
        }


        //CODE CHALLENGE:
        //display the tree as a tree
        /*
        I see a couple of ways to do this. Either traverse through the tree to find the depth I can have the appropriate number of rows in a 2D array, then find the largest breadth of the tree to make the rows of equal length. Then print "" for each space not occupied and put the key in the appropriate place.
        Another option available would be to simply use a combo of print and println, but that wouldn't necessarily look "as a tree" when printed.
         */
        public String displayTree(){

//            System.out.println("Cycle Through = " + cycleThrough(root));

            Node current = root;

            if(root == null) {
                return null;
            }

            String[][] treeArray = new String[findHeight(root)][findLeaves(root)];
            int half = findLeaves(root)/2;
            for (int row = 0; row < treeArray.length; row++) {

                cycleThrough(current.leftChild);
                cycleThrough(current.rightChild);
                String key = current.key+" ";


                for (int col = 0; col < treeArray[row].length; col++) {
                    treeArray[row][col] = key;
//                    if(current == root) {
//                        if (col == half) {
//                            treeArray[row][col] = key;
//                        } else {
//                            treeArray[row][col] = "-";
//
//                        }
//
//                    } else if (col > 0){
//                        treeArray[row][col] = key;
//
//
//                    }
                }
            }

            return Arrays.deepToString(treeArray);

        }

        private int findLeaves(Node current) {

            if(current == null) {
                return 0;
            }

            if (null == current.leftChild && null == current.rightChild) {
                return 1;
            } else {
                return findLeaves(current.leftChild) + findLeaves(current.rightChild);
            }
        }


        private int findHeight(Node current) {
            if(current == null) {
                return 0;
            } else {
            int leftmax = findHeight(current.leftChild);
            int rightmax = findHeight(current.rightChild);

            return Math.max(leftmax, rightmax)+1;
            }

        }

        public String cycleThrough(Node current) {
            if (current == null){
                return null;
            }

            System.out.print(current.key+" ");
            System.out.println();
            cycleThrough(current.leftChild);
            cycleThrough(current.rightChild);

            System.out.println();

            return current.key+"";
        }

        public void breadthFirstPrinting(){
            Queue<Node> qq = new LinkedList<>();
            StringBuffer buffer = new StringBuffer();
            int leftlevel = 0;
            int rightlevel = 0;

            qq.add(root);

            while(!qq.isEmpty()) {
                Node tempNode = qq.poll();
                System.out.println(tempNode.key);

                if (tempNode.leftChild != null) {
                    qq.add(tempNode.leftChild);
                }
                if (tempNode.rightChild != null) {
                    qq.add(tempNode.rightChild);
                }

            }
        }

}
