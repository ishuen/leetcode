// 907. Sum of Subarray Minimums
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: arr = [3,1,2,4]
// Output: 17
// Explanation:
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:
//
// Input: arr = [11,81,94,43,3]
// Output: 444
//
//
// Constraints:
//
// 1 <= arr.length <= 3 * 104
// 1 <= arr[i] <= 3 * 104
//
//
// Runtime 140 ms Beats 25.69%
// Memory 45.6 MB Beats 92.80%
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int[] leftArray = new int[arr.length];
        int[] rightArray = new int[arr.length];
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while(!leftStack.isEmpty() && arr[leftStack.peek()] > arr[i]) {
                count = count + leftArray[leftStack.peek()];
                leftStack.pop();
            }
            leftStack.push(i);
            leftArray[i] = count;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 1;
            while(!rightStack.isEmpty() && arr[rightStack.peek()] >= arr[i]) {
                count = count + rightArray[rightStack.peek()];
                rightStack.pop();
            }
            rightStack.push(i);
            rightArray[i] = count;
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + (long) leftArray[i] * rightArray[i] * arr[i]) % MOD;
        }
        return (int) sum;
    }
}