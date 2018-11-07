package LinkedList;

public class ListNode {

    public Integer data;
    public ListNode root;
    public ListNode next;

    public ListNode (int value) {
        this.data = value;
        this.next = null;
    }

    public Integer getData() {
        return data;
    }

    public ListNode getNext(){
        return next;
    }

    //Add to the class with the LinkedList - Don't just leave it here
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
