// 1297. Maximum Number of Occurrences of a Substring
//
// Given a string s, return the maximum number of occurrences of any substring under the following rules:
//
// The number of unique characters in the substring must be less than or equal to maxLetters.
// The substring size must be between minSize and maxSize inclusive.
//
//
// Example 1:
//
// Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
// Output: 2
// Explanation: Substring "aab" has 2 occurrences in the original string.
// It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
// Example 2:
//
// Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
// Output: 2
// Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// 1 <= maxLetters <= 26
// 1 <= minSize <= maxSize <= min(26, s.length)
// s consists of only lowercase English letters.
//
//
// Runtime 1195ms Beats 5.50%of users with Java
// Memory 163.72MB Beats 5.12%of users with Java
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int size = minSize; size <= maxSize; size++) {
            for (int i = 0; i + size - 1 < s.length(); i++) {
                if (checkMaxLetters(s, i, i + size - 1, maxLetters)) {
                    String key = s.substring(i, i + size);
                    int value = map.getOrDefault(key, 0) + 1;
                    map.put(key, value);
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    private boolean checkMaxLetters(String s, int left, int right, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(s.charAt(i));
        }
        return set.size() <= maxLetters;
    }
}


// Runtime 498ms Beats 12.52%of users with Java
// Memory 154.02MB Beats 5.50%of users with Java
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int size = minSize; size <= maxSize; size++) {
            for (int i = 0; i + size - 1 < s.length(); i++) {
                if (checkMaxLetters(s, i, i + size - 1, maxLetters)) {
                    String key = s.substring(i, i + size);
                    int value = map.getOrDefault(key, 0) + 1;
                    map.put(key, value);
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    private boolean checkMaxLetters(String s, int left, int right, int maxLetters) {
        boolean[] letters = new boolean[26];
        int count = 0;
        for (int i = left; i <= right; i++) {
            int index = s.charAt(i) - 'a';
            if (letters[index] == false) {
                letters[index] = true;
                count++;
            }
        }
        return count <= maxLetters;
    }
}

// Runtime 45ms Beats 64.90%of users with Java
// Memory 45.43MB Beats 70.59%of users with Java
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int len = s.length();
        for (int i = 0; i <= len - minSize; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < minSize; j++) {
                set.add(s.charAt(i + j));
            }
            if (set.size() <= maxLetters) {
                String key = s.substring(i, i + minSize);
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);
                max = Math.max(max, value);
            }
        }

        return max;
    }
}
// max occurrences always happen at the string with min size

// Runtime 35ms Beats 77.04%of users with Java
// Memory 46.04MB Beats 52.18%of users with Java
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int len = s.length();
        for (int i = 0; i <= len - minSize; i++) {
            if (checkMaxLetters(s, i, i + minSize - 1, maxLetters)) {
                String key = s.substring(i, i + minSize);
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);
                max = Math.max(max, value);
            }
        }

        return max;
    }

    private boolean checkMaxLetters(String s, int left, int right, int maxLetters) {
        boolean[] letters = new boolean[26];
        int count = 0;
        for (int i = left; i <= right; i++) {
            int index = s.charAt(i) - 'a';
            if (letters[index] == false) {
                letters[index] = true;
                count++;
            }
        }
        return count <= maxLetters;
    }
}