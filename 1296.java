// 1296. Divide Array in Sets of K Consecutive Numbers
//
// Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.
//
// Return true if it is possible. Otherwise, return false.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3,3,4,4,5,6], k = 4
// Output: true
// Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
// Example 2:
//
// Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
// Output: true
// Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
// Example 3:
//
// Input: nums = [1,2,3,4], k = 3
// Output: false
// Explanation: Each array should be divided in subarrays of size 3.
//
//
// Constraints:
//
// 1 <= k <= nums.length <= 105
// 1 <= nums[i] <= 109
//
// Runtime 136ms Beats 43.80%of users with Java
// Memory 57.09MB Beats 29.97%of users with Java
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key: map.keySet()) {
            if (!canMatch(key, k, map)) return false;
        }
        return true;
    }

    private boolean canMatch(int key, int k, Map<Integer, Integer> map) {
        int sets = map.get(key);
        if (sets == 0) return true;
        for (int i = 1; i < k; i++) {
            Integer cur = map.get(key + i);
            if (cur == null || cur < sets) return false;
            map.put(key + i, cur - sets);
        }
        map.put(key, 0);
        return true;
    }
}