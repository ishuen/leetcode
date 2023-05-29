// 877. Stone Game
//
// Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
//
// The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.
//
// Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.
//
// Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
//
//
//
// Example 1:
//
// Input: piles = [5,3,4,5]
// Output: true
// Explanation:
// Alice starts first, and can only take the first 5 or the last 5.
// Say she takes the first 5, so that the row becomes [3, 4, 5].
// If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
// If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
// This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
// Example 2:
//
// Input: piles = [3,7,2,3]
// Output: true
//
//
// Constraints:
//
// 2 <= piles.length <= 500
// piles.length is even.
// 1 <= piles[i] <= 500
// sum(piles[i]) is odd.
//
// Runtime 12 ms Beats 24.18%
// Memory 45 MB Beats 15.25%
class Solution {
    private int[][] memory;
    public boolean stoneGame(int[] piles) {
        memory = new int[piles.length][piles.length];
        return stoneGame(0, piles.length - 1, piles) > 0;
    }

    private int stoneGame(int start, int end, int[] piles) {
        if (memory[start][end] != 0) return memory[start][end];
        if (start == end) {
            memory[start][end] = piles[start];
            return piles[start];
        }
        int max = Math.max(piles[start] - stoneGame(start + 1, end, piles), piles[end] - stoneGame(start, end - 1, piles));
        memory[start][end] = max;
        return max;
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.7 MB Beats 47.34%
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}