// 472. Concatenated Words
// Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
//
// A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necesssarily distinct) in the given array.
//
//
//
// Example 1:
//
// Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
// Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
// Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
// "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
// "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
// Example 2:
//
// Input: words = ["cat","dog","catdog"]
// Output: ["catdog"]
//
//
// Constraints:
//
// 1 <= words.length <= 104
// 1 <= words[i].length <= 30
// words[i] consists of only lowercase English letters.
// All the strings of words are unique.
// 1 <= sum(words[i].length) <= 105
//
// Runtime 80 ms Beats 43%
// Memory 50.8 MB Beats 28.2%
class Solution {
    private HashMap<String, Boolean> memory;
    private Set<String> base;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        base = new HashSet<>();
        memory  = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String word: words) {
           base.add(word);
        }
        for (String word: words) {
            if (isConcat(word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isConcat(String word) {
        if (memory.get(word) != null)
            return memory.get(word);
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (base.contains(prefix) && (base.contains(suffix) || isConcat(suffix))) {
                memory.put(word, true);
                return true;
            }
        }
        memory.put(word, false);
        return false;
    }
}