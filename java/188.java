// 188. Best Time to Buy and Sell Stock IV
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
//
// Find the maximum profit you can achieve. You may complete at most k transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
// Example 1:
//
// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
// Example 2:
//
// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//
// Constraints:
//
// 0 <= k <= 100
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Runtime: 3 ms, faster than 91.58% of Java online submissions for Best Time to Buy and Sell Stock IV.
// Memory Usage: 38.8 MB, less than 37.54% of Java online submissions for Best Time to Buy and Sell Stock IV.
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int[][] profits = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int prevMax = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                profits[i][j] = Math.max(profits[i][j - 1], prevMax + prices[j]);
                prevMax = Math.max(prevMax, profits[i - 1][j - 1] - prices[j]);
            }
        }
        return profits[k][prices.length - 1];
    }
}
// if the max profit before A day - A price + cur price > max profit yesterday