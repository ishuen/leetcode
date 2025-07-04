// 123. Best Time to Buy and Sell Stock III
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
// Find the maximum profit you can achieve. You may complete at most two transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
//
//
// Example 1:
//
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// Example 2:
//
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
// Example 3:
//
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
// Example 4:
//
// Input: prices = [1]
// Output: 0
//
//
// Constraints:
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105
//
// Runtime: 7 ms, faster than 31.21% of Java online submissions for Best Time to Buy and Sell Stock III.
// Memory Usage: 49.3 MB, less than 88.23% of Java online submissions for Best Time to Buy and Sell Stock III.
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] profits = new int[3][prices.length];
        for (int i = 1; i <= 2; i++) {
            int minBuy = prices[0];
            for (int j = 1; j < prices.length; j++) {
                if (minBuy > prices[j] - profits[i - 1][j - 1]) {
                    minBuy = prices[j] - profits[i - 1][j - 1];
                }
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] - minBuy);
            }
        }
        return profits[2][prices.length - 1];
    }
}

// 1 transaction in i days, profit on ith day is
// max (profit i -1 day, price i - minBuy)
// 2 transactions in i days
// max (profit i - 1 day, 1 transaction; price i - minBuy at k day + profit k -1 day, 1 transaction )


Runtime: 3 ms, faster than 98.92% of Java online submissions for Best Time to Buy and Sell Stock III.
Memory Usage: 55 MB, less than 43.15% of Java online submissions for Best Time to Buy and Sell Stock III.
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] profits = new int[3];
        int[] minBuy = new int[3];
        Arrays.fill(minBuy, prices[0]);
        for (int j = 1; j < prices.length; j++) {
            for (int i = 1; i <= 2; i++) {
                if (minBuy[i] > prices[j] - profits[i - 1]) {
                    minBuy[i] = prices[j] - profits[i - 1];
                }
                profits[i] = Math.max(profits[i], prices[j] - minBuy[i]);
            }
        }
        return profits[2];
    }
}