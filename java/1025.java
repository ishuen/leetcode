// 1025. Divisor Game
// Alice and Bob take turns playing a game, with Alice starting first.
//
// Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
//
// Choosing any x with 0 < x < N and N % x == 0.
// Replacing the number N on the chalkboard with N - x.
// Also, if a player cannot make a move, they lose the game.
//
// Return True if and only if Alice wins the game, assuming both players play optimally.
//
//
// Example 1:
// Input: 2
// Output: true
// Explanation: Alice chooses 1, and Bob has no more moves.
//
// Example 2:
// Input: 3
// Output: false
// Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
//
// Note:
// 1 <= N <= 1000

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Divisor Game.
// Memory Usage: 38.3 MB, less than 6.88% of Java online submissions for Divisor Game.

class Solution {
    public boolean divisorGame(int N) {
        int count = 0;
        while (N > 0) {
            int ans = divide(N);
            if (ans == 0) break;
            else if (N > ans) {
                N = N - ans;
                count++;
            } else break;
        }
        if (count % 2 == 0) return false;
        return true;
    }
    
    public int divide(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 0) return i;
        }
        return 0;
    }
}