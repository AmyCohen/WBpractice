package MyCircularDeque;

import java.util.LinkedList;
import java.util.Queue;

class MyCircularDeque {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int maxSize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.maxSize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        boolean isSuccessful = false;
        if(queue1.size() < maxSize) {
            if(queue1.isEmpty()) {
               queue1.add(value);
               isSuccessful = true;
            } else {
                queue2.add(value);
                while (!queue1.isEmpty()){
                    queue2.add(queue1.poll());
                    isSuccessful = true;
                }
            }
        } else {
            isSuccessful = false;
        }

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        return isSuccessful;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

        if (queue1.size() < maxSize) {
            return queue1.add(value);
        } else {
            return false;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (queue1.isEmpty()) {
            return false;
        } else {
            queue1.poll();
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        boolean isSuccessful = false;

        if (queue1.isEmpty() && queue2.isEmpty()){
            isSuccessful = false;
        } else {

            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            int answer = queue1.poll();

            if (queue1.isEmpty()) {
                isSuccessful = true;
            }

            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
        return isSuccessful;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (queue1.isEmpty()) {
            return -1;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int answer = queue1.peek();
        queue2.add(queue1.poll());

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return answer;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (queue1.size() == maxSize){
            return true;
        } else {
            return false;
        }
    }

}

/*
    public String print() {
        StringBuffer buffer = new StringBuffer();

        if(queue1.isEmpty() && queue2.isEmpty()) {
            return "ERROR: Queue is empty.";
        }

//        while(!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
        while (!queue1.isEmpty()) {
            if(buffer.length() == 0) {
                buffer.append("HEAD <-- ");
            } else {
                buffer.append(queue2.add(queue1.poll()));
                if(queue1.isEmpty()) {

                } else {
                    buffer.append(" <-- ");
                }

            }
        }
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return buffer.toString();
    }

 */


