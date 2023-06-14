// 313. Super Ugly Number
//
// A super ugly number is a positive integer whose prime factors are in the array primes.
//
// Given an integer n and an array of integers primes, return the nth super ugly number.
//
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
//
//
//
// Example 1:
//
// Input: n = 12, primes = [2,7,13,19]
// Output: 32
// Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
// Example 2:
//
// Input: n = 1, primes = [2,3,5]
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
//
//
// Constraints:
//
// 1 <= n <= 105
// 1 <= primes.length <= 100
// 2 <= primes[i] <= 1000
// primes[i] is guaranteed to be a prime number.
// All the values of primes are unique and sorted in ascending order.
//
// Runtime 109 ms Beats 19.93%
// Memory 44.4 MB Beats 26.7%
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[] smallest = new int[n];
        for (int i = 0; i < primes.length; i++) {
            pq.add(new int[] {primes[i], 0, primes[i]});
        }
        smallest[0] = 1;
        int index = 1;
        while (index < n) {
            int[] cur = pq.remove();
            if (smallest[index - 1] != cur[2]) {
                smallest[index] = cur[2];
                index++;
            }
            pq.add(new int[] {cur[0], cur[1] + 1, cur[0] * smallest[cur[1] + 1]});
        }
        return smallest[n - 1];
    }
}