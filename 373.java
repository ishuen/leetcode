// 373. Find K Pairs with Smallest Sums
// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
// Example 1:
//
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence:
//              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:
//
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [1,1],[1,1]
// Explanation: The first 2 pairs are returned from the sequence:
//              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// Example 3:
//
// Input: nums1 = [1,2], nums2 = [3], k = 3
// Output: [1,3],[2,3]
// Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

// Runtime: 3 ms, faster than 98.98% of Java online submissions for Find K Pairs with Smallest Sums.
// Memory Usage: 39.8 MB, less than 66.21% of Java online submissions for Find K Pairs with Smallest Sums.
class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if (nums1.length == 0 || nums2.length == 0) return Collections.emptyList();
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - (b[0] + b[1]));
    for (int i = 0; i < nums1.length; i++) {
      queue.add(new int[] {nums1[i], nums2[0], 0});
    }
    List<List<Integer>> result = new ArrayList<>();
    int count = 0;
    while(count < k && !queue.isEmpty()) {
      int[] cur = queue.remove();
      result.add(Arrays.asList(cur[0], cur[1]));
      int nextIndex = cur[2] + 1;
      if (nextIndex < nums2.length) {
        queue.add(new int[] {cur[0], nums2[nextIndex], nextIndex});
      }
      count++;
    }
    return result;
  }
}