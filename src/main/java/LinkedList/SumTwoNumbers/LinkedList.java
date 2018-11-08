package LinkedList.SumTwoNumbers;

import LinkedList.ListNode;

import java.util.Arrays;

// HAD TO CHANGE METHOD TYPE TO RUN ON LEETCODE, BUT IT DIDN'T LIKE THE DECLARING THE ROOT

//import java.util.LinkedList;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class LinkedList {
    public ListNode current;
    public ListNode root;

//    public LinkedList() {
//        this.root = null;
//    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        l1.root = n1;
        n1.next = n2;
        n2.next = n3;

        LinkedList l2 = new LinkedList();
        ListNode num1 = new ListNode(1);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        l2.root = num1;
        num1.next = num2;
        num2.next = num3;

//        System.out.println(addTwoNumbers(l1, l2).print());
    }















//    public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
//
//        LinkedList actualAnswer = new LinkedList();
//
//        //Turn list one into array
//        ListNode current1 = l1.root;
//        int listSize = l1.size();
//
//        int[] list1 = new int[listSize];
//        while (current1 != null) {
//            for (int i = 0; i < listSize; i++) {
//                list1[i] = current1.data;
//                current1 = current1.next;
//            }
//        }
//        System.out.println("List 1: " + Arrays.toString(list1));
//
//        //Turn list two into array
//        ListNode current2 = l2.root;
//        int listSize2 = l2.size();
//
//        int[] list2 = new int[listSize];
//        while (current2 != null) {
//            for (int i = 0; i < listSize; i++) {
//                list2[i] = current2.data;
//                current2 = current2.next;
//            }
//        }
//        System.out.println("List 2: " + Arrays.toString(list2));
//
//        String numberBuilder1 = "";
//        String numberBuilder2 = "";
//
//        String answer = "";
//
//        for (int i = list1.length-1; i >= 0; i--){
//            numberBuilder1 += list1[i];
//        }
//        for (int i = list2.length-1; i >= 0; i--){
//            numberBuilder2 += list2[i];
//        }
//
//        answer = (Integer.parseInt(numberBuilder1) + Integer.parseInt(numberBuilder2)) + "";
//
//        String[] manipulation = answer.split("");
//
//        for (int i = 0; i < manipulation.length; i++) {
//            int addValue = Integer.parseInt(manipulation[i]);
//            actualAnswer.add(addValue);
//        }
//        actualAnswer.print();
//        return actualAnswer;
//    }
//
//    public int size() {
//        ListNode current = this.root;
//        int count = 0;
//        while (current != null) {
//            count++;
//            current = current.next;
//        }
//        return count;
//    }
//
//    public static int[] makeArray(LinkedList list){
//        ListNode current = list.root;
//        int listSize = list.size();
//
//        int[] answer = new int[listSize];
//        while (current != null) {
//            for (int i = 0; i < listSize; i++) {
//                answer[i] = current.data;
//                current = current.next;
//            }
//        }
//        return answer;
//    }
//
//    public void add(int value) {
//        ListNode addLast = new ListNode(value);
//
//        if (this.root == null) {
//            this.root = new ListNode(value);
//        } else {
//            current = root;
//        }
//
//        if (current != null) {
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = addLast;
//        }
//    }
//
//    public String print() {
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

