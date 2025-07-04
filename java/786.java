// 786. K-th Smallest Prime Fraction
// You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
//
// For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
//
// Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
//
//
//
// Example 1:
//
// Input: arr = [1,2,3,5], k = 3
// Output: [2,5]
// Explanation: The fractions to be considered in sorted order are:
// 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
// The third fraction is 2/5.
// Example 2:
//
// Input: arr = [1,7], k = 1
// Output: [1,7]
//
//
// Constraints:
//
// 2 <= arr.length <= 1000
// 1 <= arr[i] <= 3 * 104
// arr[0] == 1
// arr[i] is a prime number for i > 0.
// All the numbers of arr are unique and sorted in strictly increasing order.
// 1 <= k <= arr.length * (arr.length - 1) / 2
//
//
// Runtime 440 ms Beats 49.80%
// Memory 68.2 MB Beats 40%
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] * a[1] - a[0] * b[1]);
        int deIndex = arr.length - 1;
        boolean cont = true;
        while (pq.size() != k || cont == true) {
            for (int i = 0; i < deIndex; i++) {
                pq.add(new int[]{arr[i], arr[deIndex]});
                if (pq.size() > k) {
                    pq.remove();
                }
            }
            deIndex--;
            int[] top = pq.peek();
            if (0 < deIndex && deIndex < arr.length && top[0] * arr[deIndex] > arr[0] / top[1]) {
                cont = true;
            } else {
                cont = false;
            }
        }
        return pq.peek();
    }
}