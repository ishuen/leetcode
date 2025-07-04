// 39. Combination Sum
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
// It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
// Example 1:
//
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:
//
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:
//
// Input: candidates = [2], target = 1
// Output: []
// Example 4:
//
// Input: candidates = [1], target = 1
// Output: [[1]]
// Example 5:
//
// Input: candidates = [1], target = 2
// Output: [[1,1]]
//
//
// Constraints:
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// All elements of candidates are distinct.
// 1 <= target <= 500

// Runtime: 104 ms, faster than 29.70% of JavaScript online submissions for Combination Sum.
// Memory Usage: 45.1 MB, less than 29.64% of JavaScript online submissions for Combination Sum.

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var ans = [];
    checkSum(candidates, 0, target, [], ans);
    return ans;
};

var checkSum = function(candidates, startIndex, target, curArr, ans) {
    if (target == 0) {
        ans.push(curArr);
    } else if (target > 0) {
        for (var i = startIndex; i < candidates.length; i++) {
            checkSum(candidates, i, target - candidates[i], [...curArr, candidates[i]], ans);
    }
    }
}


// Runtime: 96 ms, faster than 61.91% of JavaScript online submissions for Combination Sum.
// Memory Usage: 40.7 MB, less than 74.79% of JavaScript online submissions for Combination Sum.
var combinationSum = function(candidates, target) {
    var ans = [];
    checkSum(candidates, 0, target, [], ans);
    return ans;
};

var checkSum = function(candidates, startIndex, target, curArr, ans) {
    if (target == 0) {
        ans.push(curArr.slice());
    } else if (target > 0) {
        for (var i = startIndex; i < candidates.length; i++) {
            curArr.push(candidates[i])
            checkSum(candidates, i, target - candidates[i], curArr, ans);
            curArr.pop();
    }
    }
}


// Runtime: 88 ms, faster than 92.67% of JavaScript online submissions for Combination Sum.
// Memory Usage: 40.7 MB, less than 74.79% of JavaScript online submissions for Combination Sum.
var combinationSum = function(candidates, target) {
    var ans = [];
    var checkSum = function(startIndex, target, curArr) {
        if (target == 0) {
            ans.push(curArr.slice());
        } else if (target > 0) {
            for (var i = startIndex; i < candidates.length; i++) {
                curArr.push(candidates[i])
                checkSum(i, target - candidates[i], curArr);
                curArr.pop();
            }
        }
    }
    checkSum(0, target, []);
    return ans;
};