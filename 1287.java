// 1287. Element Appearing More Than 25% In Sorted Array
//
// Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
//
//
//
// Example 1:
//
// Input: arr = [1,2,2,6,6,6,6,7,10]
// Output: 6
// Example 2:
//
// Input: arr = [1,1]
// Output: 1
//
//
// Constraints:
//
// 1 <= arr.length <= 104
// 0 <= arr[i] <= 105
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 43.61 MB Beats 39.19% of users with Java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int thredshold = arr.length / 4;
        int count = 1;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == cur) {
                count++;
                if (count > thredshold) return cur;
            } else {
                cur = arr[i];
                count = 1;
            }
        }
        return cur;
    }
}