// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
// You must write an algorithm that runs in O(n) time.
//
//
//
// Example 1:
//
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:
//
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
//
//
// Constraints:
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
//
// Runtime: 12 ms, faster than 88.28% of Java online submissions for Longest Consecutive Sequence.
// Memory Usage: 54.1 MB, less than 63.51% of Java online submissions for Longest Consecutive Sequence.
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                num++;
                while(set.contains(num)) {
                    num++;
                    count++;
                }
                if (count > max) max = count;
            }
        }
        return max;
    }
}