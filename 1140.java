// 1140. Stone Game II
//
// Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
//
// Alice and Bob take turns, with Alice starting first.
//
// On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.
//
// The game continues until all the stones have been taken.
//
// Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
//
//
//
// Example 1:
//
// Input: piles = [2,7,9,4,4]
//
// Output: 10
//
// Explanation:
//
// If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
// If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.
// So we return 10 since it's larger.
//
// Example 2:
//
// Input: piles = [1,2,3,4,5,100]
//
// Output: 104
//
//
//
// Constraints:
//
// 1 <= piles.length <= 100
// 1 <= piles[i] <= 104
//
// Runtime 7 ms Beats 62.47%
// Memory 42.33 MB Beats 83.16%
class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] suffixSum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        int[][] memory = new int[len][len + 1];
        return findNext(0, 1, memory, suffixSum);
    }

    private int findNext(int pile, int m, int[][] memory, int[] suffixSum) {
        int pilesNum = suffixSum.length - 1;
        if (pile > pilesNum) return 0;
        if (pile + 2 * m >= pilesNum) {
            memory[pile][m] = suffixSum[pile];
            return memory[pile][m];
        }
        if (memory[pile][m] > 0) return memory[pile][m];
        for (int x = 1; x <= 2 * m; x++) {
            memory[pile][m] = Math.max(memory[pile][m], suffixSum[pile] - findNext(pile + x, Math.max(m, x), memory, suffixSum));
        }
        return memory[pile][m];
    }
}