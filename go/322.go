// 322. Coin Change


// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

// Runtime 11 ms Beats 71.21%
// Memory 8.28 MB Beats 92.78%
func coinChange(coins []int, amount int) int {
    if amount == 0 {
        return 0
    }
    sort.Ints(coins)
    amounts := slices.Repeat([]int{math.MaxInt}, amount + 1)
    for _, value := range coins {
        if value > amount {
            break
        }
        amounts[value] = 1
    }
    for i := coins[0] + 1; i <= amount; i++ {
        for _, coin := range coins {
            if i - coin >= 0 && amounts[i - coin] != math.MaxInt {
                amounts[i] = min(amounts[i], amounts[i - coin] + 1)
            }
        }
    }
    if amounts[amount] != math.MaxInt {
        return amounts[amount]
    }
    return -1
}