// 771. Jewels and Stones

// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
// The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
// Example 1:
//
// Input: J = "aA", S = "aAAbbbb"
// Output: 3
// Example 2:
//
// Input: J = "z", S = "ZZ"
// Output: 0
// Note:
//
// S and J will consist of letters and have length at most 50.
// The characters in J are distinct.

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
// Runtime: 84 ms, faster than 63.31% of JavaScript online submissions for Jewels and Stones.
// Memory Usage: 38.7 MB, less than 83.94% of JavaScript online submissions for Jewels and Stones.
var numJewelsInStones = function(J, S) {
    let count = 0;
    for (let i = 0; i < S.length; i++) {
        if (J.indexOf(S.charAt(i)) > -1) {
            count++;
        }
    }
    return count;
};


// Runtime: 76 ms, faster than 93.09% of JavaScript online submissions for Jewels and Stones.
// Memory Usage: 38.8 MB, less than 83.94% of JavaScript online submissions for Jewels and Stones.
var numJewelsInStones = function(J, S) {
    return [...S].filter(x => J.indexOf(x) != -1).length;
};