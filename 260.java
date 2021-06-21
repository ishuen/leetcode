// 260. Single Number III
// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
//
// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
//
// Example 1:
//
// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
// Example 2:
//
// Input: nums = [-1,0]
// Output: [-1,0]
// Example 3:
//
// Input: nums = [0,1]
// Output: [1,0]
//
//
// Constraints:
//
// 2 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// Each integer in nums will appear twice, only two integers will appear once.
//
// Runtime: 3 ms, faster than 32.88% of Java online submissions for Single Number III.
// Memory Usage: 39.8 MB, less than 35.04% of Java online submissions for Single Number III.
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (numbers.contains(num)) numbers.remove(num);
            else numbers.add(num);
        }
        int[] ans = new int[2];
        Iterator it = numbers.iterator();
        int index = 0;
        while(it.hasNext()) {
            ans[index] = (int) it.next();
            index++;
        }
        return ans;
    }
}