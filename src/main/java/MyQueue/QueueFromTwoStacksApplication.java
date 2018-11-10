package MyQueue;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class QueueFromTwoStacksApplication {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        System.out.println(obj.empty()); //true

        obj.push(2);
        obj.push(4);
        obj.push(6);
        obj.push(8);
        obj.push(10);
        obj.push(12);

        System.out.println(obj.pop()); //2
        System.out.println(obj.peek()); //4

//        obj.print();
//        System.out.println(obj.print());


    }
}
