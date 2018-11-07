package LinkedList.ReversedLinkedList;

import LinkedList.ListNode;

public class LinkedList {

    public static void main(String[] args) {



        LinkedList testList2 = new LinkedList();
        ListNode num1 = new ListNode(1);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        ListNode num4 = new ListNode(4);
        ListNode num5 = new ListNode(5);
        ListNode num6 = new ListNode(6);

        num1.next = num2;
        num2.next = num3;
        num3.next = num4;
        num4.next = num5;
        num5.next = num6;

        testList2.root = num1;

        System.out.println("Original: " + testList2.print());
        reversedList(testList2);
        System.out.println("Reversed: " + testList2.print());

    }
    public ListNode root;

    public LinkedList() {
        this.root = null;
    }

    public static LinkedList reversedList(LinkedList theList) {
        ListNode current = theList.root;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        theList.root = previous;

        return theList;
    }

    //SOURCE: https://stackoverflow.com/questions/19283083/printing-out-a-linked-list-using-tostring
    public String print() {
        String result = "";
        ListNode current = root;
        if (root != null) {
            result = "" + root.data + ", ";
        }
        while(current.next != null){
            current = current.next;

            if (current.next == null) {
                result += current.data + "";
            } else {
                result += current.data + ", ";
            }
        }
        return "List: " + result;
    }

}
