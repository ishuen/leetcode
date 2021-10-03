// 893. Groups of Special-Equivalent Strings
// You are given an array of strings of the same length words.
//
// In one move, you can swap any two even indexed characters or any two odd indexed characters of a string words[i].
//
// Two strings words[i] and words[j] are special-equivalent if after any number of moves, words[i] == words[j].
//
// For example, words[i] = "zzxy" and words[j] = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz".
// A group of special-equivalent strings from words is a non-empty subset of words such that:
//
// Every pair of strings in the group are special equivalent, and
// The group is the largest size possible (i.e., there is not a string words[i] not in the group such that words[i] is special-equivalent to every string in the group).
// Return the number of groups of special-equivalent strings from words.
//
//
//
// Example 1:
//
// Input: words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
// Output: 3
// Explanation:
// One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings is all pairwise special equivalent to these.
// The other two groups are ["xyzz", "zzxy"] and ["zzyx"].
// Note that in particular, "zzxy" is not special equivalent to "zzyx".
// Example 2:
//
// Input: words = ["abc","acb","bac","bca","cab","cba"]
// Output: 3
//
//
// Constraints:
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 20
// words[i] consist of lowercase English letters.
// All the strings are of the same length.
//
// Runtime: 668 ms, faster than 5.11% of Java online submissions for Groups of Special-Equivalent Strings.
// Memory Usage: 115 MB, less than 5.11% of Java online submissions for Groups of Special-Equivalent Strings.
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        List<int[][]> list = new LinkedList<>();
        for (String word: words) {
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                int[][] mapArr = list.get(i);
                if (checkMap(word, mapArr)) {
                    found = true;
                    break;
                }
            }
            if (found == false) list.add(createMap(word));
        }
        return list.size();
    }
    
    private boolean checkMap(String word, int[][] map) {
        int[][] wordMap = createMap(word);
        for (int i = 0; i < 26; i++) {
            if (wordMap[0][i] != map[0][i]) return false;
            if (wordMap[1][i] != map[1][i]) return false;
        }
        return true;
    }
    
    private int[][] createMap(String word) {
        int[] even = new int[26];
        int[] odd = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                even[word.charAt(i) - 'a']++;
            } else {
                odd[word.charAt(i) - 'a']++;
            }
        }
        return new int[][]{even, odd};
    }
}

// Runtime: 28 ms, faster than 18.18% of Java online submissions for Groups of Special-Equivalent Strings.
// Memory Usage: 47.5 MB, less than 7.39% of Java online submissions for Groups of Special-Equivalent Strings.
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word: words) {
            boolean found = false;
            String signature = createMap(word);
            if (!set.contains(signature)) set.add(signature);
        }
        return set.size();
    }
    
    
    private String createMap(String word) {
        int[] even = new int[26];
        int[] odd = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                even[word.charAt(i) - 'a']++;
            } else {
                odd[word.charAt(i) - 'a']++;
            }
        }
        return Arrays.toString(even) + Arrays.toString(odd);
    }
}