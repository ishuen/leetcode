// 565. Array Nesting
// You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
//
// You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
//
// The first element in s[k] starts with the selection of the element nums[k] of index = k.
// The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
// We stop adding right before a duplicate element occurs in s[k].
// Return the longest length of a set s[k].
//
//
//
// Example 1:
//
// Input: nums = [5,4,0,3,1,6,2]
// Output: 4
// Explanation:
// nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
// One of the longest sets s[k]:
// s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
// Example 2:
//
// Input: nums = [0,1,2]
// Output: 1
//
//
// Constraints:
//
// 1 <= nums.length <= 105
// 0 <= nums[i] < nums.length
// All the values of nums are unique.
//
// Runtime: 17 ms, faster than 21.30% of Java online submissions for Array Nesting.
// Memory Usage: 52.5 MB, less than 11.60% of Java online submissions for Array Nesting.
class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> checked = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (checked.contains(nums[i])) continue;
            int temp = nums[i];
            int count = 0;
            while (!checked.contains(temp)) {
                checked.add(temp);
                count++;
                temp = nums[temp];
            }
            if (max < count) max = count;
        }
        return max;
    }
}

// Runtime: 2 ms, faster than 85.30% of Java online submissions for Array Nesting.
// Memory Usage: 45.7 MB, less than 41.84% of Java online submissions for Array Nesting.
class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue;
            int count = 0;
            int temp = i;
            while (nums[temp] != -1) {
                int next = nums[temp];
                nums[temp] = -1;
                count++;
                temp = next;
            }
            if (max < count) max = count;
        }
        return max;
    }
}