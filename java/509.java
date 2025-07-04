// 509. Fibonacci Number
//   The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//   F(0) = 0,   F(1) = 1
//   F(N) = F(N - 1) + F(N - 2), for N > 1.
//   Given N, calculate F(N).
//
//
//
//   Example 1:
//
//   Input: 2
//   Output: 1
//   Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//   Example 2:
//
//   Input: 3
//   Output: 2
//   Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//   Example 3:
//
//   Input: 4
//   Output: 3
//   Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//   Note:
//
//   0 ≤ N ≤ 30.

// Runtime: 7 ms, faster than 26.29% of Java online submissions for Fibonacci Number.
// Memory Usage: 36.1 MB, less than 5.51% of Java online submissions for Fibonacci Number.
public class Solution {
  public int fib(int N) {
    if (N == 0) {
      return 0;
    } else if (N == 1) {
      return 1;
    } else {
      return this.fib(N - 1) + this.fib(N - 2);
    }
  }
}


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
// Memory Usage: 36.3 MB, less than 5.51% of Java online submissions for Fibonacci Number.
class Solution {
  public int fib(int N) {
    Map<Integer, Integer> map = new HashMap<>();
    if (N <= 1) {
      return N;
    }
    map.put(0, 0);
    map.put(1, 1);
    for (int i = 2; i <= N; i++) {
      map.put(i, map.get(i - 1) + map.get(i - 2));
    }
    return map.get(N);
  }
}