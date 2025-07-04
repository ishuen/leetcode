// 279. Perfect Squares
// Given an integer n, return the least number of perfect square numbers that sum to n.
//
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
//
//
//
// Example 1:
//
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:
//
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
//
//
// Constraints:
//
// 1 <= n <= 104
//
// Runtime: 677 ms, faster than 7.39% of Java online submissions for Perfect Squares.
// Memory Usage: 57.8 MB, less than 7.48% of Java online submissions for Perfect Squares.
class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int base = 1;
        int square = 1;
        while (square <= n) {
            squares.add(square);
            base++;
            square = base * base;
        }
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 0);
        return fill(squares, n, memory);
    }
    
    private int fill(List<Integer> squares, int target, Map<Integer, Integer> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < squares.size(); i++) {
            int remained = target - squares.get(i);
            if (remained >= 0)
            min = Math.min(fill(squares, remained, memory) + 1, min);
        }
        memory.put(target, min);
        return min;
    }
}

// Runtime: 535 ms, faster than 9.46% of Java online submissions for Perfect Squares.
// Memory Usage: 57.2 MB, less than 8.07% of Java online submissions for Perfect Squares.
class Solution {
    public int numSquares(int n) {
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 0);
        return fill(n, memory);
    }
    
    private int fill(int target, Map<Integer, Integer> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= target; i++) {
            min = Math.min(fill(target - i * i, memory) + 1, min);
        }
        memory.put(target, min);
        return min;
    }
}

// Runtime: 31 ms, faster than 77.26% of Java online submissions for Perfect Squares.
// Memory Usage: 38.1 MB, less than 62.69% of Java online submissions for Perfect Squares.
class Solution {
    public int numSquares(int n) {
        int[] counts = new int[n + 1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                counts[i] = Math.min(counts[i - j * j] + 1, counts[i]);
            }
        }
        return counts[n];
    }
}