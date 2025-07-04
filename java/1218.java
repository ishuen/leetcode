// 1218. Longest Arithmetic Subsequence of Given Difference
//
// Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
//
// A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
//
//
//
// Example 1:
//
// Input: arr = [1,2,3,4], difference = 1
// Output: 4
// Explanation: The longest arithmetic subsequence is [1,2,3,4].
// Example 2:
//
// Input: arr = [1,3,5,7], difference = 1
// Output: 1
// Explanation: The longest arithmetic subsequence is any single element.
// Example 3:
//
// Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
// Output: 4
// Explanation: The longest arithmetic subsequence is [7,5,3,1].
//
//
// Constraints:
//
// 1 <= arr.length <= 105
// -104 <= arr[i], difference <= 104
//
// Runtime 47 ms Beats 36.38%
// Memory 57.06 MB Beats 69.42%
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            if (counts.containsKey(arr[i] - difference)) {
                int count = Math.max(counts.getOrDefault(arr[i], 1), counts.get(arr[i] - difference) + 1);
                counts.put(arr[i], count);
                max = Math.max(count, max);
            } else {
                counts.put(arr[i], 1);
            }
        }
        return max;
    }
}
