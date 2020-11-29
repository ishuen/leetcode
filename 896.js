// 896. Monotonic Array
// An array is monotonic if it is either monotone increasing or monotone decreasing.
//
// An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
//
// Return true if and only if the given array A is monotonic.
//
//
//
// Example 1:
//
// Input: [1,2,2,3]
// Output: true
// Example 2:
//
// Input: [6,5,4,4]
// Output: true
// Example 3:
//
// Input: [1,3,2]
// Output: false
// Example 4:
//
// Input: [1,2,4,5]
// Output: true
// Example 5:
//
// Input: [1,1,1]
// Output: true
//
//
// Note:
//
// 1 <= A.length <= 50000
// -100000 <= A[i] <= 100000


// Runtime: 92 ms, faster than 81.58% of JavaScript online submissions for Monotonic Array.
// Memory Usage: 45 MB, less than 47.37% of JavaScript online submissions for Monotonic Array.

/**
 * @param {number[]} A
 * @return {boolean}
 */
var isMonotonic = function(A) {
    if (A.length < 2) return true;
    let isIncrease = true;
    let isDecrease = true;
    for (let i = 1; i < A.length; i++) {
        isIncrease = isIncrease && A[i] >= A[i - 1];
        isDecrease = isDecrease && A[i] <= A[i - 1];
        if (!isIncrease && !isDecrease) return false;
    }
    return true;
};