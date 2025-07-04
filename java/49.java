// 49. Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
// Example 1:
//
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
//
// Input: strs = [""]
// Output: [[""]]
// Example 3:
//
// Input: strs = ["a"]
// Output: [["a"]]
//
//
// Constraints:
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.
//
// Runtime: 713 ms, faster than 5.02% of Java online submissions for Group Anagrams.
// Memory Usage: 41.5 MB, less than 96.72% of Java online submissions for Group Anagrams.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<char[]> letterCounts = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (char c: str.toCharArray()) {
                arr[c - 'a']++;
            }
            int index = findAnagram(arr, letterCounts);
            if (index == -1) {
                letterCounts.add(arr);
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
            } else {
                List<String> list = ans.get(index);
                list.add(str);
            }
        }
        return ans;
    }
    
    private int findAnagram(char[] arr, List<char[]> letterCounts) {  
        for (int i = 0; i < letterCounts.size(); i++) {
            char[] pattern = letterCounts.get(i);
            boolean found = true;
            for (int j = 0; j < 26; j++) {
                if (arr[j] != pattern[j]) {
                    found = false;
                    break;
                }
            }
            if (found == true) return i;
        }
        return -1;
    }
}

// List of arrays
// array: 26 slots, count the occurrance of each letter

// string -> array
// check if the value in the array is in the list


// Runtime: 5 ms, faster than 99.06% of Java online submissions for Group Anagrams.
// Memory Usage: 42.3 MB, less than 53.28% of Java online submissions for Group Anagrams.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

