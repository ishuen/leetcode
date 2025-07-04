// 2116. Check if a Parentheses String Can Be Valid
//
// A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
//
// It is ().
// It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
// It can be written as (A), where A is a valid parentheses string.
// You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,
//
// If locked[i] is '1', you cannot change s[i].
// But if locked[i] is '0', you can change s[i] to either '(' or ')'.
// Return true if you can make s a valid parentheses string. Otherwise, return false.
//
//
//
// Example 1:
//
//
// Input: s = "))()))", locked = "010100"
// Output: true
// Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
// We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.
// Example 2:
//
// Input: s = "()()", locked = "0000"
// Output: true
// Explanation: We do not need to make any changes because s is already valid.
// Example 3:
//
// Input: s = ")", locked = "0"
// Output: false
// Explanation: locked permits us to change s[0].
// Changing s[0] to either '(' or ')' will not make s valid.
// Example 4:
//
// Input: s = "(((())(((())", locked = "111111010111"
// Output: true
// Explanation: locked permits us to change s[6] and s[8].
// We change s[6] and s[8] to ')' to make s valid.
//
//
// Constraints:
//
// n == s.length == locked.length
// 1 <= n <= 105
// s[i] is either '(' or ')'.
// locked[i] is either '0' or '1'.
//
// Runtime 7 ms Beats 88.57%
// Memory 70.32 MB Beats 22.86%
function canBeValid(s: string, locked: string): boolean {
    if (s.length % 2 === 1) return false
    let openIndexes: number[] = []
    let unlockedIndexes: number[] = []
    for (let i = 0; i < s.length; i++) {
        if (locked.charAt(i) == '1') {
            const c = s.charAt(i)
            if (c === '(') {
                openIndexes.push(i)
            } else {
                if (openIndexes.length > 0) {
                    openIndexes.pop()
                } else if (unlockedIndexes.length > 0) {
                    unlockedIndexes.pop()
                } else {
                    return false
                }
            }
        } else {
            unlockedIndexes.push(i)
        }
    }
    while (openIndexes.length > 0 && unlockedIndexes.length > 0 && openIndexes[openIndexes.length - 1] < unlockedIndexes[unlockedIndexes.length - 1]) {
        openIndexes.pop()
        unlockedIndexes.pop()
    }
    if (openIndexes.length == 0 && unlockedIndexes.length % 2 == 0) return true
    return openIndexes.length == 0
};
