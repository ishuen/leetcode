// 540. Single Element in a Sorted Array
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
//
// Follow up: Your solution should run in O(log n) time and O(1) space.
//
//
//
// Example 1:
//
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:
//
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
//
//
// Constraints:
//
// 1 <= nums.length <= 10^5
// 0 <= nums[i] <= 10^5
//
// Runtime: 1 ms, faster than 9.27% of Java online submissions for Single Element in a Sorted Array.
// Memory Usage: 42.3 MB, less than 17.45% of Java online submissions for Single Element in a Sorted Array.
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = 0;
        for (int num: nums)
            n = n ^ num;
        return n;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
// Memory Usage: 42.2 MB, less than 20.14% of Java online submissions for Single Element in a Sorted Array.
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) mid--; // mid is always an even index
            if (nums[mid] != nums[mid + 1]) right = mid;
            else left = mid + 2;
        }
        return nums[left];
    }
}

// [1,1,2,3, 3, 4,4,8,8]
//  0 1 2 3  4  5 6 7 8