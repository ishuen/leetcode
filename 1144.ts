// 1144. Decrease Elements To Make Array Zigzag
//
// Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
//
// An array A is a zigzag array if either:
//
// Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
// OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
// Return the minimum number of moves to transform the given array nums into a zigzag array.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3]
// Output: 2
// Explanation: We can decrease 2 to 0 or 3 to 1.
// Example 2:
//
// Input: nums = [9,6,1,6,2]
// Output: 4
//
//
// Constraints:
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 1000
//
// Runtime 0 ms Beats 100.00%
// Memory 55.36 MB Beats 60.00%
function movesToMakeZigzag(nums: number[]): number {
    let moveOdd = 0
    let moveEven = 0
    for (let i = 0; i < nums.length; i++) {
        const left = i === 0 ? 1001 : nums[i - 1]
        const right = i === nums.length - 1 ? 1001 : nums[i + 1]
        const min = Math.min(left, right)
        if (i % 2 === 0) {
            moveEven = moveEven + Math.max(0, nums[i] - min + 1)
        } else {
            moveOdd = moveOdd + Math.max(0, nums[i] - min + 1)
        }
    }
    return Math.min(moveOdd, moveEven)
};
