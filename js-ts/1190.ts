// 1190. Reverse Substrings Between Each Pair of Parentheses
//
// You are given a string s that consists of lower case English letters and brackets.
//
// Reverse the strings in each pair of matching parentheses, starting from the innermost one.
//
// Your result should not contain any brackets.
//
//
//
// Example 1:
//
// Input: s = "(abcd)"
// Output: "dcba"
// Example 2:
//
// Input: s = "(u(love)i)"
// Output: "iloveu"
// Explanation: The substring "love" is reversed first, then the whole string is reversed.
// Example 3:
//
// Input: s = "(ed(et(oc))el)"
// Output: "leetcode"
// Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
//
//
// Constraints:
//
// 1 <= s.length <= 2000
// s only contains lower case English characters and parentheses.
// It is guaranteed that all parentheses are balanced.
//
// Runtime 29 ms Beats 28.57%
// Memory 61.00 MB Beats 52.38%
function reverseParentheses(s: string): string {
    const arr: string[] = s.split("")
    const firstLeft = arr.findIndex(x => x == "(")
    if (firstLeft == -1) return s
    let stack: string[] = []
    let temp: string[] = []
    let output = s.substring(0, firstLeft)
    let leftCount = 0
    for (let i = firstLeft; i < s.length; i++) {
        const c = arr[i]
        if (c == ")") {
            leftCount--
            while (stack.length > 0 && stack[stack.length - 1] != "(") {
                temp.push(stack.pop())
            }
            stack.pop()
            if (stack.length == 0) {
                output = output + temp.join("")
                temp = []
            } else {
                while (temp.length > 0) {
                    stack.push(temp.shift())
                }
            }
        } else {
            if (c == "(") {
                leftCount++
            }
            if (leftCount > 0) stack.push(c)
            else output = output + c
        }
    }
    return output + temp.join("")
};


// Runtime 3 ms Beats 75.00%
// Memory 59.11 MB Beats 70.00%
function reverseParentheses(s: string): string {
    let stack: number[] = []
    let output: string[] = []
    for (let c of s) {
        if (c === "(") {
            stack.push(output.length)
        } else if (c === ")") {
            let startIndex = stack.pop()
            let sub = output.slice(startIndex).reverse()
            output.splice(startIndex, sub.length, ...sub)
        } else {
            output.push(c)
        }
    }
    return output.join("")
};