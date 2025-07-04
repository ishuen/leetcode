// 213. House Robber II
//   You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//   Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//   Example 1:
//
//   Input: nums = [2,3,2]
//   Output: 3
//   Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
//   Example 2:
//
//   Input: nums = [1,2,3,1]
//   Output: 4
//   Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//   Total amount you can rob = 1 + 3 = 4.
//   Example 3:
//
//   Input: nums = [0]
//   Output: 0
//
//
//   Constraints:
//
//   1 <= nums.length <= 100
//   0 <= nums[i] <= 1000
// Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
// Memory Usage: 36.8 MB, less than 6.10% of Java online submissions for House Robber II.
class Solution {
    public int rob(int[] num) {
        if (num == null) return 0;
        if (num.length == 1) return num[0];
        return Math.max(rob(num, 1, num.length - 1), rob(num, 0, num.length - 2));
    }
    
    private int rob(int[] num, int startIndex, int lastIndex) {
        int include = num[startIndex];
        int exclude = 0;
        for (int i = startIndex + 1; i <= lastIndex; i++) {
            int prevInclude = include;
            include = exclude + num[i];
            exclude = Math.max(prevInclude, exclude);
        }
        return Math.max(include, exclude);
    }
}