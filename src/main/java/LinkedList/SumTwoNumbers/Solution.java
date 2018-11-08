package LinkedList.SumTwoNumbers;
import LinkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
//        [2,4,3] + [5,6,4] = [7,0,8]
        LinkedList list1 = new LinkedList();
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        list1.root = n2;
        n2.next = n4;
        n4.next = n3;

        LinkedList list2 = new LinkedList();
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode num4 = new ListNode(4);

        list1.root = n5;
        n5.next = n6;
        n6.next = num4;

        System.out.println(addTwoNumbers(list1, list2));

    }

    public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
        LinkedList answer = new LinkedList();

        ListNode l1root = l1.root;
        ListNode l1current = l1root;
        ListNode l1next = null;
        ListNode l1previous = null;

        ListNode l2root = l2.root;
        ListNode l2current = l2root;
        ListNode l2next = null;
        ListNode l2previous = null;

        while (l1current != null) {
            l1next = l1current.next;
            l1current.next = l1previous;
            l1previous = l1current;
            l1current = l1next;
        }
        l1root = l1previous;

        while (l2current != null) {
            l2next = l2current.next;
            l2current.next = l2previous;
            l2previous = l2current;
            l2current = l2next;
        }
        l2root = l2previous;

        String l1num = "";
        String l2num = "";

        while (l1current != null) {
            l1num += l1current.data;
            l1current = l1current.next;
        }

        while (l2current != null) {
            l2num += l2current.data;
            l2current = l2current.next;
        }

        String combined = (Integer.parseInt(l1num) + Integer.parseInt(l2num) + "");

        int combinedIdexValue = 0;
        ListNode answercurrent = null;
        ListNode answerroot = null;

        for (int i = 0; i < combined.length(); i++) {
            combinedIdexValue = Integer.parseInt(String.valueOf(combined.charAt(i)));

            ListNode addLast = new ListNode(combinedIdexValue);

            if (answer.root == null) {
                answer.root = new ListNode(combinedIdexValue);
            } else {
                answercurrent = answerroot;
            }

            if (answercurrent != null) {
                while (answercurrent.next != null) {
                    answercurrent = answercurrent.next;
                }
                answercurrent.next = addLast;
            }
        }

        return answer;
    }

//        public String print() {
//        String result = "";
//        ListNode current = this.root;
//        if (root != null) {
//            result = "" + root.data + " -> ";
//        }
//        while(current.next != null){
//            current = current.next;
//
//            if (current.next == null) {
//                result += current.data + "";
//            } else {
//                result += current.data + " -> ";
//            }
//        }
//        return "List: " + result;
//    }
}
