// 1186. Maximum Subarray Sum with One Deletion
//
// Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.
//
// Note that the subarray needs to be non-empty after deleting one element.
//
//
//
// Example 1:
//
// Input: arr = [1,-2,0,3]
// Output: 4
// Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
// Example 2:
//
// Input: arr = [1,-2,-2,3]
// Output: 3
// Explanation: We just choose [3] and it's the maximum sum.
// Example 3:
//
// Input: arr = [-1,-1,-1,-1]
// Output: -1
// Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
//
//
// Constraints:
//
// 1 <= arr.length <= 105
// -104 <= arr[i] <= 104
//
// Runtime 5 ms Beats 50.00%
// Memory 61.77 MB Beats 25.00%
function maximumSum(arr: number[]): number {
    let maxEndIn: number[] = new Array(arr.length).fill(Number.MIN_SAFE_INTEGER)
    let maxStartWith: number[] = new Array(arr.length).fill(Number.MIN_SAFE_INTEGER)
    let max = arr[0]
    maxEndIn[0] = arr[0]
    maxStartWith[arr.length - 1] = arr[arr.length - 1]
    for (let i = 1; i < arr.length; i++) {
        maxEndIn[i] = Math.max(maxEndIn[i - 1] + arr[i], arr[i])
        max = Math.max(max, maxEndIn[i])
    }
    for (let i = arr.length - 2; i >= 0; i--) {
        maxStartWith[i] = Math.max(arr[i], maxStartWith[i + 1] + arr[i])
    }
    for (let i = 1; i < arr.length - 1; i++) {
        max = Math.max(max, maxEndIn[i - 1] + maxStartWith[i + 1])
    }
    return max
};


// Runtime 2 ms Beats 75.00%
// Memory 56.75 MB Beats 100.00%
function maximumSum(arr: number[]): number {
    let noDelete = arr[0]
    let oneDelete = 0
    let max = noDelete
    for (let i = 1; i < arr.length; i++) {
        oneDelete = Math.max(noDelete, oneDelete + arr[i]) // noDelete represents delete itself
        noDelete = Math.max(arr[i], noDelete + arr[i])
        max = Math.max(max, oneDelete, noDelete)
    }
    return max
};
