// 1053. Previous Permutation With One Swap
//
// Given an array of positive integers arr (not necessarily distinct), return the
// lexicographically
// largest permutation that is smaller than arr, that can be made with exactly one swap. If it cannot be done, then return the same array.
//
// Note that a swap exchanges the positions of two numbers arr[i] and arr[j]
//
//
//
// Example 1:
//
// Input: arr = [3,2,1]
// Output: [3,1,2]
// Explanation: Swapping 2 and 1.
// Example 2:
//
// Input: arr = [1,1,5]
// Output: [1,1,5]
// Explanation: This is already the smallest permutation.
// Example 3:
//
// Input: arr = [1,9,4,6,7]
// Output: [1,7,4,6,9]
// Explanation: Swapping 9 and 7.
//
//
// Constraints:
//
// 1 <= arr.length <= 104
// 1 <= arr[i] <= 104
//
// Runtime 0 ms Beats 100%
// Memory 44.9 MB Beats 65.17%
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int index = arr.length - 1;
        while (index > 0) {
            if (arr[index] < arr[index - 1]) {
                int last = index;
                for (int i = last + 1; i < arr.length; i++) {
                    if (arr[i] >= arr[index - 1]) {
                        break;
                    }
                    if (arr[last] < arr[i]) {
                        last = i;
                    }
                }
                int temp = arr[index - 1];
                arr[index - 1] = arr[last];
                arr[last] = temp;
                break;
            }
            index--;
        }
        return arr;
    }
}
