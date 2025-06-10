// 3442. Maximum Difference Between Even and Odd Frequency I
//
// You are given a string s consisting of lowercase English letters.
//
// Your task is to find the maximum difference diff = a1 - a2 between the frequency of characters a1 and a2 in the string such that:
//
// a1 has an odd frequency in the string.
// a2 has an even frequency in the string.
// Return this maximum difference.
//
//
//
// Example 1:
//
// Input: s = "aaaaabbc"
//
// Output: 3
//
// Explanation:
//
// The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
// The maximum difference is 5 - 2 = 3.
// Example 2:
//
// Input: s = "abcabcab"
//
// Output: 1
//
// Explanation:
//
// The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
// The maximum difference is 3 - 2 = 1.
//
//
// Constraints:
//
// 3 <= s.length <= 100
// s consists only of lowercase English letters.
// s contains at least one character with an odd frequency and one with an even frequency.
//
// Runtime 1 ms Beats 95.45%
// Memory 58.40 MB Beats 68.18%
function maxDifference(s: string): number {
    let counter: number[] = new Array(26).fill(0)
    const base = "a".charCodeAt(0)
    for (let i = 0; i < s.length; i++) {
        counter[s.charCodeAt(i) - base]++
    }
    let minEven = Number.MAX_SAFE_INTEGER
    let maxOdd = 0
    for (let i = 0; i < 26; i++) {
        if (counter[i] > maxOdd && counter[i] % 2 == 1) {
            maxOdd = counter[i]
        } else if (counter[i] !== 0 && counter[i] < minEven && counter[i] % 2 == 0) {
            minEven = counter[i]
        }
    }
    return maxOdd - minEven
};
