// 641. Design Circular Deque
//
// Design your implementation of the circular double-ended queue (deque).
// Implement the MyCircularDeque class:
//
// MyCircularDeque(int k) Initializes the deque with a maximum size of k.
// boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
// int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
// int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
// boolean isEmpty() Returns true if the deque is empty, or false otherwise.
// boolean isFull() Returns true if the deque is full, or false otherwise.
//
//
// Example 1:
//
// Input
// ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
// [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
// [null, true, true, true, false, 2, true, true, true, 4]
//
// Explanation
// MyCircularDeque myCircularDeque = new MyCircularDeque(3);
// myCircularDeque.insertLast(1);  // return True
// myCircularDeque.insertLast(2);  // return True
// myCircularDeque.insertFront(3); // return True
// myCircularDeque.insertFront(4); // return False, the queue is full.
// myCircularDeque.getRear();      // return 2
// myCircularDeque.isFull();       // return True
// myCircularDeque.deleteLast();   // return True
// myCircularDeque.insertFront(4); // return True
// myCircularDeque.getFront();     // return 4
//
//
// Constraints:
//
// 1 <= k <= 1000
// 0 <= value <= 1000
// At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
//
// Runtime: 5 ms, faster than 45.60% of Java online submissions for Design Circular Deque.
// Memory Usage: 39.3 MB, less than 92.61% of Java online submissions for Design Circular Deque.
class MyCircularDeque {

    private Deque<Integer> deque;
    private int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new LinkedList<>();
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque.addFirst(value);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque.addLast(value);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        deque.removeFirst();
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        deque.removeLast();
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return deque.getFirst();
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return deque.getLast();
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.size() == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return deque.size() == size;
    }
}

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


// Runtime: 4 ms, faster than 99.49% of Java online submissions for Design Circular Deque.
// Memory Usage: 39.7 MB, less than 47.64% of Java online submissions for Design Circular Deque.
class MyCircularDeque {

    private Node head;
    private Node tail;
    private int size;
    private int curSize;
    
    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
        }
    }
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
        curSize = 0;
        head = new Node(-1);
        tail = new Node(-1);
        tail.prev = head;
        head.next = tail;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node cur = head.next;
        node.next = cur;
        node.prev = head;
        cur.prev = node;
        head.next = node;
        curSize++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node cur = tail.prev;
        node.prev = cur;
        cur.next = node;
        node.next = tail;
        tail.prev = node;
        curSize++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        curSize--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        curSize--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (curSize == 0) return -1;
        return head.next.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (curSize == 0) return -1;
        return tail.prev.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize == size;
    }
}
