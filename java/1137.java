// 1137. N-th Tribonacci Number
// The Tribonacci sequence Tn is defined as follows:
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
// Given n, return the value of Tn.
//
//
//
// Example 1:
//
// Input: n = 4
// Output: 4
// Explanation:
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4
// Example 2:
//
// Input: n = 25
// Output: 1389537
//
//
// Constraints:
//
// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

// Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
// Memory Usage: 36 MB, less than 54.09% of Java online submissions for N-th Tribonacci Number.
class Solution {
    Map<Integer, Integer> memory;
    public int tribonacci(int n) {
        memory = new HashMap<>();
        memory.put(0, 0);
        memory.put(1, 1);
        memory.put(2, 1);
        return tri(n);
    }
    
    public int tri(int n) {
        if (memory.containsKey(n)) return memory.get(n);
        int sum = tri(n - 1) + tri(n - 2) + tri(n - 3);
        memory.put(n, sum);
        return sum;
    }
}