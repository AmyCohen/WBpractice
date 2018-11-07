package LinkedList.CircularLinkedList;

import LinkedList.ListNode;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList testList1 = new LinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        testList1.root = n1;

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

        System.out.println("List 1 = " + testList1.isCircularList());
        System.out.println("List 2 = " + testList2.isCircularList());
    }
/////////////////////////////////////////////////


    //declare an instance of root
    public ListNode root;

    //set the root to null initially and attached to the LinkedList
    public LinkedList () {
        this.root = null;
    }

    //This is a method that will be appended to the list to detect of it is circular
    public Boolean isCircularList () {
        //set the current to the root
        ListNode current = this.root;

        //set both the walker and runner to current
        ListNode walker = current;
        ListNode runner = current;

        //If walker (currently set to root) is null then it cannot be circular
        if (walker.next == null) {
            return false;
        }


        //Keep checking for a circular reference or a loop while the walker isn't null (This would create an infinite loop if walker was incremented inside and the check was made to determine a loop.
        while (walker != null) {

            //Walker is set to it's own next.
            walker = walker.next;
            //Runner is set to it's own next.next.
            runner = runner.next.next;

            //If walker and runner are the same, then YES this is a circular linked list (and stops the while loop from running)
            if (walker == runner) {
                return true;

            //If runner.next.next is null then the list cannot be circular and it also avoids a null pointer exception that could be caused by running off the end of the list.
            } else if (runner.next.next == null) {
                return false;
            }
        }
        return false;
    }

}
