// 442. Find All Duplicates in an Array
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
// You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
//
//
// Example 1:
//
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]
// Example 2:
//
// Input: nums = [1,1,2]
// Output: [1]
// Example 3:
//
// Input: nums = [1]
// Output: []
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
// Each element in nums appears once or twice.
//
// Runtime 20 ms Beats 24.7%
// Memory 51.8 MB Beats 7.93%
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int num: nums) {
            if(set.contains(num)) {
                ans.add(num);
            } else {
                set.add(num);
            }
        }
        return ans;
    }
}

// Runtime 6 ms Beats 82.54%
// Memory 50.8 MB Beats 55.63%
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // n == nums.length, 1 <= nums[i] <= n means that there is no need to worry about index out of bound
        List<Integer> ans = new ArrayList<>();
        for(int num: nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
               ans.add(index + 1);
            } else {
               nums[index] *= -1;
            }
        }
        return ans;
    }
}