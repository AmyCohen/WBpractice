package MyStack;

/*
Notes:

* You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
* Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
* You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1){
            queue2.add(queue1.poll());
        }

        int answer = queue1.poll();

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return answer;
    }

    /** Get the top element. */
    public int top() {
        while (queue1.size() > 1){
            queue2.add(queue1.poll());
        }
        int answer = queue1.peek();
        queue2.add(queue1.poll());

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return answer;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()){
            return true;
        } else {
            return false;
        }

    }
}