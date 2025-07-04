// 788. Rotated Digits
//
// X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
//
// A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
//
// Now given a positive number N, how many numbers X from 1 to N are good?
//
// Example:
// Input: 10
// Output: 4
// Explanation:
// There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
// Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
// Note:
//
// N  will be in range [1, 10000].

/**
 * @param {number} N
 * @return {number}
 */
// Runtime: 116 ms, faster than 9.52% of JavaScript online submissions for Rotated Digits.
// Memory Usage: 45 MB, less than 25.00% of JavaScript online submissions for Rotated Digits.
var rotatedDigits = function(N) {
    var count = 0;
    for (var i = 1; i <= N; i++) {
        var str = ("" + i).split("");
        if (str.includes('2') || str.includes('5') || str.includes('6') || str.includes('9')) {
            if (!str.includes('3') && !str.includes('4') && !str.includes('7')) {
                count++;
            }
        }
    }
    return count;
};

// Runtime: 80 ms, faster than 92.26% of JavaScript online submissions for Rotated Digits.
// Memory Usage: 38.8 MB, less than 81.55% of JavaScript online submissions for Rotated Digits.

var rotatedDigits = function(N) {
    let count = 0;
    
    for (let i = 1; i <= N; i += 1) {
        const num = i.toString();
        
        if (num.indexOf('3') !== -1) continue;
        if (num.indexOf('4') !== -1) continue;
        if (num.indexOf('7') !== -1) continue;
        
        count += num.indexOf('2') !== -1 ?
            1 : num.indexOf('5') !== -1 ?
                1: num.indexOf('6') !== -1 ?
                    1: num.indexOf('9') !== -1 ?
                        1: 0;
    }
    
    return count;
};