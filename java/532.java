// 532. K-diff Pairs in an Array
//
// Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
// A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//
// 0 <= i, j < nums.length
// i != j
// nums[i] - nums[j] == k
// Notice that |val| denotes the absolute value of val.
//
//
//
// Example 1:
//
// Input: nums = [3,1,4,1,5], k = 2
// Output: 2
// Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
// Although we have two 1s in the input, we should only return the number of unique pairs.
// Example 2:
//
// Input: nums = [1,2,3,4,5], k = 1
// Output: 4
// Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
// Example 3:
//
// Input: nums = [1,3,1,5,4], k = 0
// Output: 1
// Explanation: There is one 0-diff pair in the array, (1, 1).
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// -107 <= nums[i] <= 107
// 0 <= k <= 107
//
// Runtime 5 ms Beats 89.87%
// Memory 42.7 MB Beats 75.69%
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        while (left < right && right < nums.length) {
            int diff = nums[right] - nums[left];
            if (diff < k) {
                right++;
            } else if (diff > k) {
                left++;
            } else {
                int sameLeft = 1;
                int sameRight = 1;
                while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                    sameLeft++;
                    left++;
                }
                while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    sameRight++;
                    right++;
                }
                count++;
                left++;
                right++;
            }
            if (right == left) right++;
        }
        return count;
    }
}

// Runtime 10 ms Beats 66.48%
// Memory 42.7 MB Beats 68.88%
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key: map.keySet()) {
            int target = key + k;
            if (map.containsKey(target) && (key != target || map.get(target) > 1)) {
                count++;
            }
        }
        return count;
    }
}