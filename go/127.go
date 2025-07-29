// 127. Word Ladder

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

// Constraints:

// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.

// Runtime 128 ms Beats 48.23%
// Memory 7.25 MB Beats 97.98%
func ladderLength(beginWord string, endWord string, wordList []string) int {
    queue := []string{}
    steps := 1
    queue = append(queue, beginWord)
    for ; len(queue) > 0; {
        size := len(queue)
        for i := 0; i < size; i++ {
            cur := queue[i]
            // fmt.Println(steps, cur)
            if cur == endWord {
                return steps
            }
            length := len(wordList)
            index := 0
            for j := 0; j < length; j++ {
                if canTransform(cur, wordList[index]) {
                    queue = append(queue, wordList[index])
                    wordList = append(wordList[:index], wordList[index + 1:]...)
                } else {
                    index++
                }
            }
        }
        steps++
        queue = queue[size:]
    }
    return 0
}

func canTransform(word string, target string) bool {
    diffCount := 0
    for index, _ := range word {
        if (word[index] != target[index]) {
            diffCount++
            if (diffCount > 1) {
                return false
            }
        }
    }
    return diffCount == 1
}