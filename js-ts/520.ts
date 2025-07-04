// 520. Detect Capital
//
// We define the usage of capitals in a word to be right when one of the following cases holds:
//
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.
//
//
//
// Example 1:
//
// Input: word = "USA"
// Output: true
// Example 2:
//
// Input: word = "FlaG"
// Output: false
//
//
// Constraints:
//
// 1 <= word.length <= 100
// word consists of lowercase and uppercase English letters.
//
// Runtime 0 ms Beats 100.00%
// Memory 55.74 MB Beats 81.93%
function detectCapitalUse(word: string): boolean {
    let counter = 0;
    let isFirstCapital = false;
    const aCode = "a".charCodeAt(0)
    for (let i = 0; i < word.length; i++) {
        const c = word.charAt(i);
        if (word.charCodeAt(i) < aCode) {
            if (i == 0) {
                isFirstCapital = true;
            }
            counter++
        }
    }
    if (counter === 0 || counter === word.length) return true
    return counter === 1 && isFirstCapital
};
