// Max Consecutive Ones III
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//
//
//
// Example 1:
//
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:
//
// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length
// Runtime: 2 ms, faster than 99.88% of Java online submissions for Count of Smaller Numbers After Self.
// Memory Usage: 40.2 MB, less than 63.69% of Java online submissions for Count of Smaller Numbers After Self.
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int max = 0;
        int counter = 0;
        for (int end = start; end < nums.length; end++) {
            if (nums[end] == 0) {
                counter++;
                while (counter > k) {
                    if (nums[start] == 0) counter--;
                    start++;
                }
            }
            if (end - start + 1 > max) max = end - start + 1;
        }
        return max;
    }
}