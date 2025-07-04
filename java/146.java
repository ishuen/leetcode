// 146. LRU Cache
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
// Implement the LRUCache class:
//
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// Follow up:
// Could you do get and put in O(1) time complexity?
//
// Example 1:
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
//
//
// Constraints:
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// At most 3 * 104 calls will be made to get and put.
//
// Runtime: 162 ms, faster than 5.40% of Java online submissions for LRU Cache.
// Memory Usage: 47.2 MB, less than 52.71% of Java online submissions for LRU Cache.
class LRUCache {
    private class ListNode {
        int key;
        ListNode next;
        ListNode prev;
        public ListNode(int key) {
            this.key = key;
        }
    }
   
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
           updateOrder(key);
        }
        return cache.getOrDefault(key, -1);
    }
    
    private void updateOrder(int key) {
        ListNode cur = head;
        if (head.key != key) {
            while (cur.key != key) {
                cur = cur.next;
            }
            ListNode prev = cur.prev;
            ListNode next = cur.next;
            prev.next = next;
            if (next != null) next.prev = prev;
            if (cur == tail) tail = prev;
            head.prev = cur;
            cur.next = head;
            head = cur;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateOrder(key);
        } else {
            if (cache.size() == capacity && capacity > 1) {
                ListNode toRemove = tail;
                ListNode prev = tail.prev;
                prev.next = null;
                cache.remove(tail.key);
                tail = prev;
            } else if (cache.size() == capacity && capacity == 1) {
                cache.remove(tail.key);
                head = null;
                tail = null;
            }
            int size = cache.size();
            if (size < capacity) {
                ListNode newNode = new ListNode(key);
                if (size >= 1) {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                } else {
                    head = newNode;
                    tail = newNode;
                }
                cache.put(key, value);
            } 
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// Runtime: 12 ms, faster than 98.68% of Java online submissions for LRU Cache.
// Memory Usage: 47.6 MB, less than 18.40% of Java online submissions for LRU Cache.
class LRUCache {
    private class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
   
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private Map<Integer, ListNode> cache;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = cache.getOrDefault(key, null);
        if (node != null) updateOrder(node);
        return node == null ? -1 : node.val;
    }
    
    private void updateOrder(ListNode cur) {
        removeNode(cur);
        addNode(cur);
    }
    private void addNode(ListNode newNode) {
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }
    
    private void removeNode(ListNode toRemove) {
        if (head == toRemove && tail == toRemove) {
            head = null;
            tail = null;
        } else if (head == toRemove) {
            toRemove.prev = null;
            ListNode next = toRemove.next;
            head = toRemove.next;
            next.prev = null;
        } else {
            ListNode prev = toRemove.prev;
            ListNode next = toRemove.next;
            if (tail == toRemove) {
                tail = prev;
            }
            prev.next = toRemove.next;
            if (next != null) next.prev = prev;
            }
        }
        
    public void put(int key, int value) {
        ListNode existingNode = cache.get(key);
        if (existingNode != null) {
            existingNode.val = value;
            updateOrder(existingNode);
        } else {
            ListNode newNode = new ListNode(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                cache.remove(tail.key);
                removeNode(tail);
            } 
        } 
    }
}