// 146. LRU Cache

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

 

// Example 1:

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

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
 

// Constraints:

// 1 <= capacity <= 3000
// 0 <= key <= 104
// 0 <= value <= 105
// At most 2 * 105 calls will be made to get and put.

// Runtime 194 ms Beats 5.45%
// Memory 69.57 MB Beats 85.96%
type LRUCache struct {
    store map[int]int
    order []int
    capacity int
}


func Constructor(capacity int) LRUCache {
    return LRUCache{
        order: []int{},
        store: make(map[int]int),
        capacity: capacity,
    }
}


func (this *LRUCache) Get(key int) int {
    val, ok := this.store[key]
    if !ok {
        return -1
    }
    index := slices.IndexFunc(this.order, func(n int) bool {
		return n == key
	})
    this.order = append(this.order[:index], this.order[index + 1:]...)
    this.order = append(this.order, key)
    return val
}


func (this *LRUCache) Put(key int, value int)  {
    _, ok := this.store[key]
    if ok {
        this.store[key] = value
        index := slices.IndexFunc(this.order, func(n int) bool {
		    return n == key
	    })
        this.order = append(this.order[:index], this.order[index + 1:]...)
        this.order = append(this.order, key)
        return
    }
    if len(this.store) == this.capacity {
        delete(this.store, this.order[0])
        this.order = this.order[1:]
    }
    this.store[key] = value
    this.order = append(this.order, key)
}

// Runtime 104 ms Beats 26.04%
// Memory 68.37 MB Beats 90.84%
type Node struct {
    Key int
    Value int
    Next *Node
    Prev *Node
}

type LRUCache struct {
    Data map[int]*Node
    Capacity int
    Head *Node
    Tail *Node
}

func (this *LRUCache) remove(node *Node) {
    node.Prev.Next = node.Next
    node.Next.Prev = node.Prev
}

func (this *LRUCache) addToHead(node *Node) {
    node.Prev = this.Head
    node.Next = this.Head.Next
    this.Head.Next.Prev = node
    this.Head.Next = node
}


func Constructor(capacity int) LRUCache {
    head := &Node{}
    tail := &Node{}
    head.Next = tail
    tail.Prev = head

    return LRUCache{
        Data: make(map[int]*Node),
        Capacity: capacity,
        Head: head,
        Tail: tail,
    }
}


func (this *LRUCache) Get(key int) int {
    node, ok := this.Data[key]
    if !ok {
        return -1
    }

    this.remove(node)
    this.addToHead(node)

    return node.Value
}


func (this *LRUCache) Put(key int, value int)  {
    if node, ok := this.Data[key]; ok {
        this.remove(node)
        this.addToHead(node)

        node.Value = value
        return
    }

    if len(this.Data) >= this.Capacity {
        node := this.Tail.Prev

        this.remove(node)
        delete(this.Data, node.Key)
    }

    new := &Node{
        Key: key,
        Value: value,
    }
    this.addToHead(new)
    this.Data[key] = new
}
