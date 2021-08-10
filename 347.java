// 347. Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
// Example 1:
//
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
//
//
// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
// Runtime: 9 ms, faster than 83.58% of Java online submissions for Top K Frequent Elements.
// Memory Usage: 41.6 MB, less than 67.03% of Java online submissions for Top K Frequent Elements.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            Element temp = new Element(entry.getKey(), entry.getValue());
            pq.add(temp);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Element top = pq.remove();
            ans[i] = top.num;
        }
        return ans;
    }
    
    class Element {
        int num;
        int count = 0;
        public Element(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
}