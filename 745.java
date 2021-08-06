// 745. Prefix and Suffix Search
// Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.
//
// Implement the WordFilter class:
//
// WordFilter(string[] words) Initializes the object with the words in the dictionary.
// f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
//
//
// Example 1:
//
// Input
// ["WordFilter", "f"]
// [[["apple"]], ["a", "e"]]
// Output
// [null, 0]
//
// Explanation
// WordFilter wordFilter = new WordFilter(["apple"]);
// wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
//
//
// Constraints:
//
// 1 <= words.length <= 15000
// 1 <= words[i].length <= 10
// 1 <= prefix.length, suffix.length <= 10
// words[i], prefix and suffix consist of lower-case English letters only.
// At most 15000 calls will be made to the function f.
//
// Runtime: 385 ms, faster than 34.74% of Java online submissions for Prefix and Suffix Search.
// Memory Usage: 65.1 MB, less than 70.59% of Java online submissions for Prefix and Suffix Search.
class WordFilter {
    Map<String, Integer> map = new HashMap<>();
    public WordFilter(String[] words) {
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            for (int i = 1; i <= word.length(); i++) {
                for (int j = 0; j < word.length(); j++)
                map.put(word.substring(0, i) + "-" + word.substring(j), k);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "-" + suffix, -1);
    }
}
