// 41. First Missing Positive
// Given an unsorted integer array nums, find the smallest missing positive integer.
//
// You must implement an algorithm that runs in O(n) time and uses constant extra space.
//
// Example 1:
//
// Input: nums = [1,2,0]
// Output: 3
// Example 2:
//
// Input: nums = [3,4,-1,1]
// Output: 2
// Example 3:
//
// Input: nums = [7,8,9,11,12]
// Output: 1
//
//
// Constraints:
//
// 1 <= nums.length <= 5 * 105
// -231 <= nums[i] <= 231 - 1
//
// Runtime: 212 ms, faster than 5.34% of Java online submissions for First Missing Positive.
// Memory Usage: 100.5 MB, less than 6.07% of Java online submissions for First Missing Positive.
class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) pq.add(nums[i]);
        }
        while (!pq.isEmpty()) {
            if (pq.peek() == count) {
                count++;
                pq.poll();
            } else if (pq.peek() == count - 1) {
                pq.poll();
            } else {
                return count;
            }
        }
        return count;
    }
}


Runtime: 7 ms, faster than 11.82% of Java online submissions for First Missing Positive.
Memory Usage: 93.7 MB, less than 8.74% of Java online submissions for First Missing Positive.
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                arr[nums[i] - 1] = true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != true) return i + 1;
        }
        return arr.length + 1;
    }
}