// 312. Burst Balloons
//
// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
//
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
//
// Return the maximum coins you can collect by bursting the balloons wisely.
//
//
//
// Example 1:
//
// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
// Example 2:
//
// Input: nums = [1,5]
// Output: 10
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 300
// 0 <= nums[i] <= 100
//
//
// Runtime 246 ms Beats 55.00%
// Memory 57.54 MB Beats 95.00%
function maxCoins(nums: number[]): number {
    let len = nums.length + 2
    let arr = new Array(len)
    arr[0] = 1
    arr[len - 1] = 1
    for (let i = 0; i < nums.length; i++) {
        arr[i + 1] = nums[i]
    }
    let memo: number[][] = new Array(len)
    for (let i = 0; i < len; i++) {
        memo[i] = new Array(len).fill(0)
    }
    return calcMaxCoins(arr, memo, 0, len - 1)
};

function calcMaxCoins(arr: number[], memo: number[][], left: number, right: number): number {
    if (left + 1 == right) return 0
    if (memo[left][right] > 0) return memo[left][right]
    let max = 0;
    for (let i = left + 1; i < right; i++) {
        max = Math.max(max, arr[left] * arr[i] * arr[right] + calcMaxCoins(arr, memo, left, i) + calcMaxCoins(arr, memo, i, right))
    }
    memo[left][right] = max
    return max
}