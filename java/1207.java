// 1207. Unique Number of Occurrences
//
// Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
//
//
//
// Example 1:
//
// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
// Example 2:
//
// Input: arr = [1,2]
// Output: false
// Example 3:
//
// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
//
//
// Constraints:
//
// 1 <= arr.length <= 1000
// -1000 <= arr[i] <= 1000
//
// Runtime 2 ms Beats 98.18% of users with Java
// Memory 40.18 MB Beats 92.64% of users with Java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num: arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(occurrences.values());
        return set.size() == occurrences.size();
    }
}