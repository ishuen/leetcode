// 137. Single Number II
// Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
// You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
// Example 1:
//
// Input: nums = [2,2,3,2]
// Output: 3
// Example 2:
//
// Input: nums = [0,1,0,1,0,1,99]
// Output: 99
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// Each element in nums appears exactly three times except for one element which appears once.
//
// Runtime: 4 ms, faster than 36.86% of Java online submissions for Single Number II.
// Memory Usage: 38.8 MB, less than 35.28% of Java online submissions for Single Number II.
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number II.
// Memory Usage: 39 MB, less than 28.55% of Java online submissions for Single Number II.
class Solution {
    public int singleNumber(int[] nums) {
        int oneTime = 0;
        int twoTimes = 0;
        for (int num : nums) {
            oneTime = oneTime ^ num & (~twoTimes);
            twoTimes = twoTimes ^ num & (~oneTime);
        }
        return oneTime;
    }
}

// oneTime ^ num & (twoTimes's complement) -> num appears one time
// twoTimes ^ num & (oneTime's complement) -> num appears two times