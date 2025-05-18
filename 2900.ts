// 2900. Longest Unequal Adjacent Groups Subsequence I
//
// A subsequence of words is alternating if for any two consecutive strings in the sequence, their corresponding elements at the same indices in groups are different (that is, there cannot be consecutive 0 or 1).
//
// Your task is to select the longest alternating subsequence from words.
//
// Return the selected subsequence. If there are multiple answers, return any of them.
//
// Note: The elements in words are distinct.
//
//
//
// Example 1:
//
// Input: words = ["e","a","b"], groups = [0,0,1]
//
// Output: ["e","b"]
//
// Explanation: A subsequence that can be selected is ["e","b"] because groups[0] != groups[2]. Another subsequence that can be selected is ["a","b"] because groups[1] != groups[2]. It can be demonstrated that the length of the longest subsequence of indices that satisfies the condition is 2.
//
// Example 2:
//
// Input: words = ["a","b","c","d"], groups = [1,0,1,1]
//
// Output: ["a","b","c"]
//
// Explanation: A subsequence that can be selected is ["a","b","c"] because groups[0] != groups[1] and groups[1] != groups[2]. Another subsequence that can be selected is ["a","b","d"] because groups[0] != groups[1] and groups[1] != groups[3]. It can be shown that the length of the longest subsequence of indices that satisfies the condition is 3.
//
//
//
// Constraints:
//
// 1 <= n == words.length == groups.length <= 100
// 1 <= words[i].length <= 10
// groups[i] is either 0 or 1.
// words consists of distinct strings.
// words[i] consists of lowercase English letters.
//
// Runtime 1 ms Beats 62.50%
// Memory 58.96 MB Beats 60.42%
function getLongestSubsequence(words: string[], groups: number[]): string[] {
    let lastIndex = 0;
    let output = [words[lastIndex]];
    for (let i = 1; i < words.length; i++) {
        if (groups[i] !== groups[lastIndex]) {
            output.push(words[i]);
            lastIndex = i;
        }
    }
    return output;
};
