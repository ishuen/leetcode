// 1137. N-th Tribonacci Number
//
// The Tribonacci sequence Tn is defined as follows:
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
// Given n, return the value of Tn.
//
//
//
// Example 1:
//
// Input: n = 4
// Output: 4
// Explanation:
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4
// Example 2:
//
// Input: n = 25
// Output: 1389537
//
//
// Constraints:
//
// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
//
// Runtime 55 ms Beats 33.77% of users with JavaScript
// Memory 41.13 MB Beats 95.12% of users with JavaScript
/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    if (n == 0) return 0;
    if (n == 1 || n == 2) return 1;
    let n0 = 0;
    let n1 = 1;
    let n2 = 1;
    for (let i = 3; i <= n; i++) {
        let temp = n0 + n1 + n2;
        n0 = n1;
        n1 = n2;
        n2 = temp;
    }
    return n2;
};