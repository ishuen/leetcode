// 1814. Count Nice Pairs in an Array
//
// You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
//
// 0 <= i < j < nums.length
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
// Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: nums = [42,11,1,97]
// Output: 2
// Explanation: The two pairs are:
//  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
//  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
// Example 2:
//
// Input: nums = [13,10,35,24,76]
// Output: 4
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
//
// Runtime 30 ms Beats 65.64% of users with Java
// Memory 54.60 MB Beats 69.13% of users with Java
class Solution {
    public int countNicePairs(int[] nums) {
        long count = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int num: nums) {
            int diff = num - rev(num);
            int c = diffMap.getOrDefault(diff, 0) + 1;
            diffMap.put(diff, c);
        }

        for (int value: diffMap.values()) {
            count = (count + ((long)value * (value - 1) / 2) % mod) % mod;
        }
        return (int) count;
    }
    private int rev(int num) {
        int next = 0;
        while (num > 0) {
            next = next * 10 + num % 10;
            num = num / 10;
        }
        return next;
    }
}


/*
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
=> nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
pair that has same diff
map<diff, count> -> sum product of (count * (count - 1) / 2)
42 - 24 = 18
11        0
1.        0
97 - 79  = 18

*/