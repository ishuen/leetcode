// 1051. Height Checker
// Students are asked to stand in non-decreasing order of heights for an annual photo.
//
// Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
//
// Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
//
//
//
// Example 1:
//
// Input: heights = [1,1,4,2,1,3]
// Output: 3
// Explanation:
// Current array : [1,1,4,2,1,3]
// Target array  : [1,1,1,2,3,4]
// On index 2 (0-based) we have 4 vs 1 so we have to move this student.
// On index 4 (0-based) we have 1 vs 3 so we have to move this student.
// On index 5 (0-based) we have 3 vs 4 so we have to move this student.
// Example 2:
//
// Input: heights = [5,1,2,3,4]
// Output: 5
// Example 3:
//
// Input: heights = [1,2,3,4,5]
// Output: 0
//
//
// Constraints:
//
// 1 <= heights.length <= 100
// 1 <= heights[i] <= 100
//
// Runtime: 80 ms, faster than 60.71% of JavaScript online submissions for Height Checker.
// Memory Usage: 39.1 MB, less than 12.34% of JavaScript online submissions for Height Checker.
/**
 * @param {number[]} heights
 * @return {number}
 */
var heightChecker = function(heights) {
    let origin = Object.assign({}, heights);
    let count = 0;
    let len = heights.length;
    for (let i = 0; i < len; i++) {
        heights = swapToFirst(heights, i);
    }
    for (let i = 0; i < len; i++) {
        if (origin[i] != heights[i]) {
            count++;
        }
    }
    return count;
};

function swapToFirst(heights, startIndex) {
    let min = heights[startIndex];
    let minIndex = startIndex;
    for (let i = startIndex + 1; i < heights.length; i++) {
        if (heights[i] < min) {
            min = heights[i];
            minIndex = i;
        }
    }
    if (startIndex != minIndex) {
        let temp = heights[startIndex];
        heights[startIndex] = heights[minIndex];
        heights[minIndex] = temp;
    }
    return heights;
}

// Runtime: 76 ms, faster than 85.25% of JavaScript online submissions for Height Checker.
// Memory Usage: 38.8 MB, less than 28.79% of JavaScript online submissions for Height Checker.
var heightChecker = function(heights) {
    let sorted = [...heights].sort((a, b) => a - b);
    let count = 0;
    let len = heights.length;
    for (let i = 0; i < len; i++) {
        if (sorted[i] != heights[i]) {
            count++;
        }
    }
    return count;
};