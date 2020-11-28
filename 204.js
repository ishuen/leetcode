// 204. Count Primes
// Count the number of prime numbers less than a non-negative number, n.
// Example 1:
// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
// Example 2:
// Input: n = 0
// Output: 0
// Example 3:
//
// Input: n = 1
// Output: 0

// Constraints:
// 0 <= n <= 5 * 10^6


/**
 * @param {number} n
 * @return {number}
 */

// Runtime: 348 ms, faster than 31.85% of JavaScript online submissions for Count Primes.
// Memory Usage: 102.3 MB, less than 26.76% of JavaScript online submissions for Count Primes.
var countPrimes = function(n) {
    if (n <= 1) return 0
    let count = 0;
    let prime = {2: true}
    for (let i = 2; i < n; i++) {
        if (prime[i] != false) {
            prime[i] = true;
            for (let j = 2; j * i < n; j++) {
                prime[j * i] = false;
            }
            count++;
        }
    }
    return count;
};

// Runtime: 156 ms, faster than 69.44% of JavaScript online submissions for Count Primes.
// Memory Usage: 66.5 MB, less than 36.57% of JavaScript online submissions for Count Primes.
var countPrimes = function(num) {
    const res = new Array(num).fill(false); // res = not prime
    res[0] = true;
    res[1] = true;
    const m = Math.sqrt(num);
    for (let i = 2; i < m; i++) {
        if (!res[i]) {
            for (let j = i; j * i< num; j++) {
                res[j * i] = true;
            }
        }
    }
    return res.filter(x => !x).length;
}

