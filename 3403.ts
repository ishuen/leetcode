// 3403. Find the Lexicographically Largest String From the Box I
//
// You are given a string word, and an integer numFriends.
//
// Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
//
// word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
// All the split words are put into a box.
// Find the lexicographically largest string from the box after all the rounds are finished.
//
//
//
// Example 1:
//
// Input: word = "dbca", numFriends = 2
//
// Output: "dbc"
//
// Explanation:
//
// All possible splits are:
//
// "d" and "bca".
// "db" and "ca".
// "dbc" and "a".
// Example 2:
//
// Input: word = "gggg", numFriends = 4
//
// Output: "g"
//
// Explanation:
//
// The only possible split is: "g", "g", "g", and "g".
//
//
//
// Constraints:
//
// 1 <= word.length <= 5 * 103
// word consists only of lowercase English letters.
// 1 <= numFriends <= word.length
//
// Runtime 128 ms Beats 7.69%
// Memory 59.25 MB Beats 15.38%
function answerString(word: string, numFriends: number): string {
    if (numFriends <= 1) return word
    let windowSize = word.length - numFriends + 1
    let largest = word.substring(0, windowSize)
    for (let i = 1; i < numFriends; i++) {
        largest = compare(largest, word.substring(i, i + windowSize))
    }
    for (let i = numFriends; i < word.length; i++) {
        largest = compare(largest, word.substring(i))
    }
    return largest
};

function compare(s1: string, s2: string):string {
    const len = Math.min(s1.length, s2.length)
    for (let i = 0; i < len; i++) {
        const c1 = s1.charCodeAt(i)
        const c2 = s2.charCodeAt(i)
        if (c1 > c2) return s1
        else if (c2 > c1) return s2
    }
    if (s1.length > s2.length) return s1
    else if (s1.length < s2.length) return s2
    return s1
}


// Runtime 2 ms Beats 84.62%
// Memory 58.75 MB Beats 23.08%
function answerString(word: string, numFriends: number): string {
    if (numFriends <= 1) return word
    let windowSize = word.length - numFriends + 1
    let largest = word.substring(0, windowSize)
    for (let i = 1; i < numFriends; i++) {
        const sub = word.substring(i, i + windowSize)
        largest = largest > sub ? largest : sub
    }
    for (let i = numFriends; i < word.length; i++) {
        const sub = word.substring(i)
        largest = largest > sub ? largest : sub
    }
    return largest
};
