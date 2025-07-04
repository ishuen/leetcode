// 845. Longest Mountain in Array
// You may recall that an array arr is a mountain array if and only if:
//
// arr.length >= 3
// There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
//
//
//
// Example 1:
//
// Input: arr = [2,1,4,7,3,2,5]
// Output: 5
// Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
// Example 2:
//
// Input: arr = [2,2,2]
// Output: 0
// Explanation: There is no mountain.
//
//
// Constraints:
//
// 1 <= arr.length <= 104
// 0 <= arr[i] <= 104
//
//
// Follow up:
//
// Can you solve it using only one pass?
// Can you solve it in O(1) space?
//
// Runtime 3 ms Beats 36.24%
// Memory 43.6 MB Beats 46.32%
class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int max = 0;
        int startIndex = 0;
        int curCount = 1;
        boolean direction = true; // true = up
        while (startIndex < arr.length) {
            if (startIndex + 1 < arr.length && direction == true && arr[startIndex] < arr[startIndex + 1]) {
                curCount++;
            } else if (startIndex + 1 < arr.length && direction == true && curCount > 1 && arr[startIndex] > arr[startIndex + 1]) {
                curCount++;
                direction = false;
            } else if (startIndex + 1 < arr.length && direction == false && arr[startIndex] > arr[startIndex + 1]) {
                curCount++;
            } else {
                if (direction == false) {
                    max = Math.max(curCount, max);
                    direction = true;
                    startIndex--;
                }
                curCount = 1;
            }
            startIndex++;
        }
        return max <= 1 ? 0 : max;
    }
}

// Runtime 2 ms Beats 100%
// Memory 43.5 MB Beats 56.81%
class Solution {
    public int longestMountain(int[] arr) {
        int max = 0;
        int startIndex = 0;
        int curCount = 1;
        while (startIndex < arr.length) {
            while (startIndex + 1 < arr.length && arr[startIndex] < arr[startIndex + 1]) {
                curCount++;
                startIndex++;
            } 
            if (startIndex + 1 < arr.length && arr[startIndex] > arr[startIndex + 1] && curCount > 1) {
                while (startIndex + 1 < arr.length && arr[startIndex] > arr[startIndex + 1]) {
                    curCount++;
                    startIndex++;
                }
                max = Math.max(curCount, max);
                startIndex--;
            }
            curCount = 1;
            startIndex++;
        }
        return max <= 2 ? 0 : max;
    }
}