// 121. Best Time to Buy and Sell Stock
// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
// Note that you cannot sell a stock before you buy one.
//
// Example 1:
//   Input: [7,1,5,3,6,4]
//   Output: 5
//   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//                Not 7-1 = 6, as selling price needs to be larger than buying price.
// Example 2:
//   Input: [7,6,4,3,1]
//   Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

// 368 ms, faster than 7.56%
class Solution {
public:
  int maxProfit(vector<int>& prices) {
    int len = prices.size();
    if (len < 2) return 0;
    int maxProfit = prices[1] - prices[0];
    for (int i = 0; i < len; i++) {
      for (int j = i+1; j < len; j++) {
        int temp = prices[j] - prices[i];
        if (temp < 0) {
          continue;
        } else if (temp > maxProfit) {
          maxProfit = temp;
        }
      }
    }
    if(maxProfit < 0) return 0;
    return maxProfit;
  }
};

// 4 ms, faster than 99.49%
// This method only works when the revenue is set to be greater than 0. That is when there is negative revenue, no transaction is done.
class Solution {
public:
  int maxProfit(vector<int>& prices) {
    int len = prices.size();
    if (len < 2) return 0;
    int min = prices[0];
    int maxProfit = 0;
    for (int i = 0; i < len; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else {
        int temp = prices[i] - min;
        if (temp > maxProfit) {
          maxProfit = temp;
        }
      }
    }
    return maxProfit;
  }
};