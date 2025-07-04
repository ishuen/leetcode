// 2131. Longest Palindrome by Concatenating Two Letter Words
//
// You are given an array of strings words. Each element of words consists of two lowercase English letters.
//
// Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
//
// Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
//
// A palindrome is a string that reads the same forward and backward.
//
//
//
// Example 1:
//
// Input: words = ["lc","cl","gg"]
// Output: 6
// Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
// Note that "clgglc" is another longest palindrome that can be created.
// Example 2:
//
// Input: words = ["ab","ty","yt","lc","cl","ab"]
// Output: 8
// Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
// Note that "lcyttycl" is another longest palindrome that can be created.
// Example 3:
//
// Input: words = ["cc","ll","xx"]
// Output: 2
// Explanation: One longest palindrome is "cc", of length 2.
// Note that "ll" is another longest palindrome that can be created, and so is "xx".
//
//
// Constraints:
//
// 1 <= words.length <= 105
// words[i].length == 2
// words[i] consists of lowercase English letters.
//
// Runtime 125 ms Beats 23.08%
// Memory 72.00 MB Beats 46.15%
function longestPalindrome(words: string[]): number {
    const repeatSet = new Set<string>();
    const mirrorMap = new Map<string, number>();
    let count = 0;
    for (let word of words) {
        if (word.charAt(0) === word.charAt(1)) {
            if (repeatSet.has(word)) {
                repeatSet.delete(word);
                count = count + 2
            } else {
                repeatSet.add(word)
            }
        } else {
            const reversed = word.split('').reverse().join('')
            let record = mirrorMap.get(reversed)
            let current = mirrorMap.get(word)
            if (record > 0) {
                mirrorMap.set(reversed, record - 1)
                count = count + 2
            } else if (current) {
                mirrorMap.set(word, current + 1)
            } else {
                mirrorMap.set(word, 1)
            }
        }
    }
    if (repeatSet.size > 0) count++;
    return count * 2
};


// Runtime 62 ms Beats 38.46%
// Memory 70.66 MB Beats 53.85%
function longestPalindrome(words: string[]): number {
    const map = new Map<string, number>();
    let count = 0;
    let repeatedCount = 0
    for (let word of words) {
        let current = map.get(word)
        if (word.charAt(0) === word.charAt(1)) {
            if (current > 0) {
                map.set(word, current - 1);
                count = count + 2
                repeatedCount--
            } else {
                map.set(word, 1)
                repeatedCount++
            }
        } else {
            const reversed = word[1] + word[0]
            let record = map.get(reversed)
            if (record > 0) {
                map.set(reversed, record - 1)
                count = count + 2
            } else if (current) {
                map.set(word, current + 1)
            } else {
                map.set(word, 1)
            }
        }
    }
    if (repeatedCount > 0) count++;
    return count * 2
};