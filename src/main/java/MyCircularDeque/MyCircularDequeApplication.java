package MyCircularDeque;


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

public class MyCircularDequeApplication {
    public static void main(String[] args) {

/*
["MyCircularDeque","insertFront","deleteLast","deleteLast","insertLast","getRear","insertLast","isFull","getRear","isFull","deleteLast","isEmpty","getFront","isEmpty","insertFront","isEmpty","insertLast","getRear","getFront","deleteLast","deleteLast","insertLast","insertLast","deleteLast","getFront","insertLast","isEmpty","getFront","insertFront","insertLast","insertFront","deleteLast","getRear","getRear","insertFront","insertLast","deleteFront","getFront","getFront","insertLast","getFront","getFront","insertFront","getFront","deleteFront","deleteFront","deleteFront","insertLast","getRear","insertFront","isFull","insertLast","deleteLast","getRear","deleteLast","getRear","insertFront","deleteLast","insertLast","insertLast","getFront","getRear","insertFront","insertLast","insertLast","insertFront","getRear","getRear","deleteLast","insertFront","getFront","insertFront","insertLast","getRear","insertFront","insertLast","deleteFront","isEmpty","getRear","insertLast","insertFront","getFront","getRear","insertFront","insertLast","deleteLast","deleteLast","isFull","insertLast","deleteLast","deleteFront","insertFront","getRear","isFull","deleteFront","getFront","getRear","isEmpty","getFront","deleteLast","getRear","insertLast"]
[[71],[47],[],[],[66],[],[72],[],[],[],[],[],[],[],[53],[],[15],[],[],[],[],[9],[87],[],[],[98],[],[],[33],[40],[21],[],[],[],[69],[14],[],[],[],[60],[],[],[15],[],[],[],[],[97],[],[66],[],[23],[],[],[],[],[30],[],[54],[18],[],[],[50],[24],[24],[25],[],[],[],[0],[],[86],[31],[],[55],[55],[],[],[],[18],[49],[],[],[53],[44],[],[],[],[46],[],[],[58],[],[],[],[],[],[],[],[],[],[61]]
 */
        MyCircularDeque obj = new MyCircularDeque(4);
        System.out.println("Is Empty = " + obj.isEmpty());

        obj.insertFront(9);
        obj.deleteLast();
        obj.getRear();
        obj.getFront();
        obj.getFront();
        obj.deleteFront();
        obj.insertFront(6);
        obj.insertLast(5);
        obj.insertFront(9);
        obj.getFront(); //9
        obj.insertFront(6);

//        System.out.println("Full Deque = " + obj.print());

        System.out.println("Delete Front = " + obj.deleteFront()); //10
        System.out.println("Delete Last = " + obj.deleteLast()); //8
        System.out.println("Get Front = " + obj.getFront()); //6
        System.out.println("Get Rear = " + obj.getRear()); //4
        System.out.println("Is Empty = " + obj.isEmpty()); //false
        System.out.println("Is Full = " + obj.isFull()); //false

        obj.insertLast(12);
        obj.insertLast(13);
        System.out.println("Is Full = " + obj.isFull()); //true



    }
}
