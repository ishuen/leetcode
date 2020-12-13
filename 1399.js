// 1399. Count Largest Group
// Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
// Return how many groups have the largest size.
// Example 1:
// Input: n = 13
// Output: 4
// Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
// [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
// Example 2:
// Input: n = 2
// Output: 2
// Explanation: There are 2 groups [1], [2] of size 1.
// Example 3:
// Input: n = 15
// Output: 6
// Example 4:
// Input: n = 24
// Output: 5
// Constraints:
// 1 <= n <= 10^4

// Runtime: 92 ms, faster than 59.63% of JavaScript online submissions for Count Largest Group.
// Memory Usage: 39.7 MB, less than 76.15% of JavaScript online submissions for Count Largest Group.

var countLargestGroup = function(n) {
    let groups = {};
    for (let i = 1; i <= n; i++) {
        let temp = i;
        while (temp % 10 == 0 && temp >= 10) {
            temp = temp / 10;
        }
        let sum = 0;
        for (let j = 0; j < String(temp).length; j++) {
            sum = sum + Number(String(temp).charAt(j));
        }
        groups[sum] = groups[sum] ? groups[sum] + 1 : 1;
    }
    let maxSize = 0;
    let maxCount = 0;
    for (let key in groups) {
        if (groups[key] > maxSize) {
            maxSize = groups[key];
            maxCount = 1;
        } else if (groups[key] == maxSize) {
            maxCount++;
        }
    }
    return maxCount;
};


// Runtime: 84 ms, faster than 94.50% of JavaScript online submissions for Count Largest Group.
// Memory Usage: 39.3 MB, less than 78.90% of JavaScript online submissions for Count Largest Group.
var countLargestGroup = function(n) {
    let groups = {};
    for (let i = 1; i <= n; i++) {
        let temp = i;
        let sum = 0;
        while (temp >= 10) {
            sum = sum + temp % 10;
            temp = Math.floor(temp / 10);
        }
        sum = sum + temp;
        groups[sum] = groups[sum] ? groups[sum] + 1 : 1;
    }
    let maxSize = 0;
    let maxCount = 0;
    for (let key in groups) {
        if (groups[key] > maxSize) {
            maxSize = groups[key];
            maxCount = 1;
        } else if (groups[key] == maxSize) {
            maxCount++;
        }
    }
    return maxCount;
};