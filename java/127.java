// 127. Word Ladder
// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
//
// Example 1:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
// Example 2:
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//
// Constraints:
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
//
// Runtime: 59 ms, faster than 69.65% of Java online submissions for Word Ladder.
// Memory Usage: 40.6 MB, less than 70.34% of Java online submissions for Word Ladder.
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> currentStep = new LinkedList<>();
        currentStep.add(beginWord);
        int length = beginWord.length();
        int step = 1;
        while(!currentStep.isEmpty()) {
            int size = currentStep.size();
            while (size > 0) {
                String cur = currentStep.remove();
                for (int i = 0; i < length; i++) {
                    StringBuilder str = new StringBuilder(cur);
                    for (char c = 'a'; c <= 'z'; c++) {
                        str.setCharAt(i, c);
                        String s = str.toString();
                        if (words.contains(s)) {
                            if (s.equals(endWord)) return step + 1;
                            currentStep.add(s);
                            words.remove(s);
                        }
                    }
                }
                size--;
            }
            step++;
        }
        return 0;
    }
}