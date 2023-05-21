// 808. Soup Servings
//
// There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds of operations:
//
// Serve 100 ml of soup A and 0 ml of soup B,
// Serve 75 ml of soup A and 25 ml of soup B,
// Serve 50 ml of soup A and 50 ml of soup B, and
// Serve 25 ml of soup A and 75 ml of soup B.
// When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.
//
// Note that we do not have an operation where all 100 ml's of soup B are used first.
//
// Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time. Answers within 10-5 of the actual answer will be accepted.
//
//
//
// Example 1:
//
// Input: n = 50
// Output: 0.62500
// Explanation: If we choose the first two operations, A will become empty first.
// For the third operation, A and B will become empty at the same time.
// For the fourth operation, B will become empty first.
// So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
// Example 2:
//
// Input: n = 100
// Output: 0.71875
//
//
// Constraints:
//
// 0 <= n <= 109
//
//
// Runtime 10 ms Beats 45.21%
// Memory 43.6 MB Beats 39.73%
class Solution {
    private Map<String, Double> memory;
    public double soupServings(int n) {
        memory = new HashMap<>();
		// without simplification to return 1, it will be a StackOverflowError
		// explanation: https://leetcode.com/problems/soup-servings/solutions/121711/c-java-python-when-n-4800-just-return-1/
        return n > 4800 ? 1 : soupServings((n + 24)/25, (n + 24)/25);
    }

    private double soupServings(int a, int b) {
        if (memory.containsKey(a + "-" + b)) return memory.get(a + "-" + b);
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        Double prob = 0.25 * soupServings(a - 4, b) + 0.25 * soupServings(a - 3, b - 1) + 0.25 * soupServings(a - 2, b - 2) + 0.25 * soupServings(a - 1, b - 3);
        memory.put(a + "-" + b, prob);
        return prob;
    }
}
