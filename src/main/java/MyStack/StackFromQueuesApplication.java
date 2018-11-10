package MyStack;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class StackFromQueuesApplication {
    public static void main(String[] args) {
        MyStack obj = new MyStack();

        System.out.println(obj.empty());

        obj.push(2);
        obj.push(4);
        obj.push(6);
        obj.push(8);
        obj.push(10);
        obj.push(12);

        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}
