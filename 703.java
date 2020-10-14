// 703. Kth Largest Element in a Stream
//   Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//   Implement KthLargest class:
//
//   KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
//   int add(int val) Returns the element representing the kth largest element in the stream.
//
//
//   Example 1:
//
//   Input
//   ["KthLargest", "add", "add", "add", "add", "add"]
//   [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//   Output
//   [null, 4, 5, 5, 8, 8]
//
//   Explanation
//   KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//   kthLargest.add(3);   // return 4
//   kthLargest.add(5);   // return 5
//   kthLargest.add(10);  // return 5
//   kthLargest.add(9);   // return 8
//   kthLargest.add(4);   // return 8
//
//
//   Constraints:
//
//   1 <= k <= 104
//   0 <= nums.length <= 104
//   -104 <= nums[i] <= 104
//   -104 <= val <= 104
//   At most 104 calls will be made to add.

// Runtime: 211 ms, faster than 10.53% of Java online submissions for Kth Largest Element in a Stream.
// Memory Usage: 44.8 MB, less than 17.16% of Java online submissions for Kth Largest Element in a Stream.
// no removal of the item
// kth largest element from the initial list => this number never decrease
// if the new element < kth largest element => no change on the result
class KthLargest {

    int k;
    int kth = -10000;
    int empty;
    int[] largerNums;
    
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (k <= length) {
            largerNums = Arrays.copyOfRange(nums, length - k, length);
            kth = largerNums[0];
        } else{
            largerNums = new int[k];
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                largerNums[i] = nums[i];
                }
            }
            this.empty = k - length;
        }
        this.k = k;
    }
    
    public int add(int val) {
        if (val < kth) return kth;
        if (empty > 0) {
            largerNums[k - empty] = val;
            empty = empty - 1;
            if (empty > 0) return -10000;
            Arrays.sort(largerNums);
            kth = largerNums[0];
        } else {
            largerNums[0] = val;
            if (k > 1) {
                Arrays.sort(largerNums);
                kth = largerNums[0];
            } else {
                kth = val;
            }
        }
        
        return kth;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


// Runtime: 11 ms, faster than 100.00% of Java online submissions for Kth Largest Element in a Stream.
// Memory Usage: 42.8 MB, less than 17.14% of Java online submissions for Kth Largest Element in a Stream.

class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

