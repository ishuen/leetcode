// 1239. Maximum Length of a Concatenated String with Unique Characters
// Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
//
// Return the maximum possible length of s.
//
//
//
// Example 1:
//
// Input: arr = ["un","iq","ue"]
// Output: 4
// Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
// Maximum length is 4.
// Example 2:
//
// Input: arr = ["cha","r","act","ers"]
// Output: 6
// Explanation: Possible solutions are "chaers" and "acters".
// Example 3:
//
// Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
// Output: 26
//
//
// Constraints:
//
// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] contains only lower case English letters.
//
// Runtime: 12 ms, faster than 78.40% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
// Memory Usage: 36.3 MB, less than 99.04% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
class Solution {
    public int maxLength(List<String> arr) {
        List<boolean[]> subs = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            boolean[] usage = new boolean[26];
            boolean hasDuplicate = false;
            for (int j = 0; j < s.length(); j++) {
                if (usage[s.charAt(j) - 'a'] == true) {
                    arr.set(i, "");
                    subs.add(new boolean[26]);
                    hasDuplicate = true;
                    break;
                }
                usage[s.charAt(j) - 'a'] = true;
            }
            if (hasDuplicate == false) subs.add(usage);
        }
        return getMax(0, new boolean[26], subs, arr);
    }
    
    private int getMax(int start, boolean[] used, List<boolean[]> subs, List<String> arr) {
        int count = 0;
        for (int i = start; i < subs.size(); i++) {
            if (hasDuplicated(used, subs.get(i))) continue;
            addCur(used, subs.get(i));
            count = Math.max(count, arr.get(i).length() + getMax(i + 1, used, subs, arr));
            removeCur(used, subs.get(i));
        }
        return count;
    }
    
    private boolean hasDuplicated(boolean[] used, boolean[] cur) {
        for (int i = 0; i < 26; i++) {
            if (used[i] == true && cur[i] == true) return true;
        }
        return false;
    }
    
    private void addCur(boolean[] used, boolean[] cur) {
        for (int i = 0; i < 26; i++) {
            if (cur[i] == true) used[i] = true;
        }
    }
    
    private void removeCur(boolean[] used, boolean[] cur) {
        for (int i = 0; i < 26; i++) {
            if (cur[i] == true) used[i] = false;
        }
    }
}

