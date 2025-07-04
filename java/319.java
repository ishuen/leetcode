// 319. Bulb Switcher
// There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
//
// On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
//
// Return the number of bulbs that are on after n rounds.
//
//
//
// Example 1:
//
//
// Input: n = 3
// Output: 1
// Explanation: At first, the three bulbs are [off, off, off].
// After the first round, the three bulbs are [on, on, on].
// After the second round, the three bulbs are [on, off, on].
// After the third round, the three bulbs are [on, off, off].
// So you should return 1 because there is only one bulb is on.
// Example 2:
//
// Input: n = 0
// Output: 0
// Example 3:
//
// Input: n = 1
// Output: 1
//
//
// Constraints:
//
// 0 <= n <= 109
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Bulb Switcher.
// Memory Usage: 35.7 MB, less than 65.60% of Java online submissions for Bulb Switcher.
class Solution {
    public int bulbSwitch(int n) { 
        return (int) Math.sqrt(n);
    }
}

// for every number except for the perfect square
// the number of switches = even
// 1 on
// 2 (1 on, 2 off)
// 3 (1 on, 3 off)
// 4 (1 on, 2 off, 4 on)
// k (1 on, a off, b on, k off) if k = a * b