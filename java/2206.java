// 2206. Divide Array Into Equal Pairs
//
// You are given an integer array nums consisting of 2 * n integers.
//
// You need to divide nums into n pairs such that:
//
// Each element belongs to exactly one pair.
// The elements present in a pair are equal.
// Return true if nums can be divided into n pairs, otherwise return false.
//
//
//
// Example 1:
//
// Input: nums = [3,2,3,2,2,2]
// Output: true
// Explanation:
// There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
// If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
// Example 2:
//
// Input: nums = [1,2,3,4]
// Output: false
// Explanation:
// There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
//
//
// Constraints:
//
// nums.length == 2 * n
// 1 <= n <= 500
// 1 <= nums[i] <= 500
//
// Runtime 6 ms Beats 45.22%
// Memory 44.99 MB Beats 13.78%
class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.isEmpty();
    }
}

// Runtime 1 ms Beats 100.00%
// Memory 45.00 MB Beats 13.78%
class Solution {
    public boolean divideArray(int[] nums) {
        int[] counts = new int[501];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) return false;
        }
        return true;
    }
}
