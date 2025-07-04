// 322. Coin Change
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
//
// Example 1:
//
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:
//
// Input: coins = [2], amount = 3
// Output: -1
// Example 3:
//
// Input: coins = [1], amount = 0
// Output: 0
// Example 4:
//
// Input: coins = [1], amount = 1
// Output: 1
// Example 5:
//
// Input: coins = [1], amount = 2
// Output: 2
//
//
// Constraints:
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Runtime: 16 ms, faster than 53.84% of Java online submissions for Coin Change.
// Memory Usage: 38.5 MB, less than 56.27% of Java online submissions for Coin Change.
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] counts = new int[amount + 1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        int index = 0;
        for (int i = coins[0]; i <= amount; i++) {
            if (index < coins.length && coins[index] == i) {
                counts[i] = 1;
                while(index < coins.length - 1 && coins[index] == i) 
                    index++;
            } else {
                for (int j = 0; j < coins.length; j++) {
                    if (i > coins[j] && counts[coins[j]] != Integer.MAX_VALUE && counts[i - coins[j]] != Integer.MAX_VALUE)
                    counts[i] = Math.min(counts[i], counts[coins[j]] + counts[i - coins[j]]);
                }
            }
        }
        return counts[amount] == Integer.MAX_VALUE ? -1 : counts[amount];
    }
}