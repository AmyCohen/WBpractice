package MyQueue;
/*
Notes:

* You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
* Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
* You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int answer = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return answer;
    }

    /** Get the front element. */
    public int peek() {

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int answer = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return answer;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}

/*
    public String print() {
        StringBuffer buffer = new StringBuffer();

        if(stack1.isEmpty() && stack2.isEmpty()) {
            return "ERROR: Queue is empty.";
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            if(buffer.length() == 0) {
                buffer.append("HEAD <-- ");
            } else {
                buffer.append(stack1.push(stack2.pop()));
                if(stack2.isEmpty()) {

                } else {
                    buffer.append(" <-- ");
                }

            }
        }
        return buffer.toString();
    }
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
