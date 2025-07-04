// 76. Minimum Window Substring
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
// The testcases will be generated such that the answer is unique.
//
// A substring is a contiguous sequence of characters within the string.
//
//
//
// Example 1:
//
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:
//
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:
//
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
//
//
// Constraints:
//
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.

// Runtime: 80 ms, faster than 8.55% of Java online submissions for Minimum Window Substring.
// Memory Usage: 39.9 MB, less than 38.25% of Java online submissions for Minimum Window Substring.
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;
        Map<Character, Integer> curMap = new HashMap<>();
        int minStart = 0;
        int minEnd = s.length() - 1;
        int cur = 0;
        boolean fit = false;
        while (cur < s.length()) {
            char c = s.charAt(cur);
            boolean hasKey = targetMap.containsKey(c);
            end = cur;
            if (hasKey) {
                if (curMap.isEmpty()) start = cur;
                curMap.put(c, curMap.getOrDefault(c, 0) + 1);
                if (hasAllRequired(curMap, targetMap)) {
                    fit = true;
                    if (end - start < minEnd - minStart) {
                        minStart = start;
                        minEnd = end;
                    }
                    // remove first char and non-relevant ones
                    boolean shouldCheck = true;
                    while (start < end && shouldCheck) {
                        curMap.put(s.charAt(start), curMap.get(s.charAt(start)) - 1);
                        start++;
                        while (!targetMap.containsKey(s.charAt(start))) {
                            start++;
                        }
                        shouldCheck = hasAllRequired(curMap, targetMap);
                        if (shouldCheck && end - start < minEnd - minStart) {
                            minStart = start;
                            minEnd = end;
                        }
                    }
                }
                    
            }
            cur++;
        }
        return fit ? s.substring(minStart, minEnd + 1) : "";
    }
    
    private boolean hasAllRequired(Map<Character, Integer> curMap, Map<Character, Integer> targetMap) {
        if (curMap.size() != targetMap.size()) return false;
        Iterator it = curMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
            if (targetMap.get(entry.getKey()) > entry.getValue()) return false;
        }
        return true;
    }
}

// {"A": 1, "B":1, "C": 1}
// {"A": 1, "D": 1, "O": 1.. } see if the target map is the submap
// start from first occurance of the target map element

// Runtime: 11 ms, faster than 63.11% of Java online submissions for Minimum Window Substring.
// Memory Usage: 39 MB, less than 81.25% of Java online submissions for Minimum Window Substring.
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0;
        int remained = t.length();
        int minStart = 0;
        int minEnd = s.length() - 1;
        boolean fit = false;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (targetMap.containsKey(c)) {
                int count = targetMap.get(c);
                targetMap.put(c, targetMap.get(c) - 1);
                if (count >= 1) remained--;
                if (remained == t.length()) start = end;
            }
            while (remained == 0) {
                fit = true;
                if (end - start < minEnd - minStart) {
                    minStart = start;
                    minEnd = end;
                }
                char sc = s.charAt(start);
                if (targetMap.containsKey(sc)) {
                    int count = targetMap.get(sc);
                    targetMap.put(sc, count + 1);
                    if (count >=0 ) remained++;
                }
                start++;
            }
        }
        return fit ? s.substring(minStart, minEnd + 1) : "";
    }
}


// Runtime 4 ms Beats 79.34%
// Memory 45.14 MB Beats 54.42%
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) return s;
        int L = 0;
        int R = 0;
        int min = s.length() + 1;
        int count = 0;
        String minString = "";
        int[][] countTable = new int[2][52]; // 1st row = target, 2nd = current
        Arrays.fill(countTable[0], 0);
        Arrays.fill(countTable[1], 0);
        for (int i = 0; i < t.length(); i++) {
            addToTable(t.charAt(i), countTable[0]);
        }
        while (L <= R && R < s.length() && L < s.length()) {
            char c = s.charAt(R);
            int index = findIndexFromTable(c);
            if (countTable[0][index] <= countTable[1][index]) {
                countTable[1][index]++;
                R++;
                continue;    
            }
            countTable[1][index]++;
            count++;
            if (count < t.length()) {
                R++;
                continue;
            }
            int indexL = findIndexFromTable(s.charAt(L));
            while (countTable[0][indexL] < countTable[1][indexL]) {
                countTable[1][indexL]--;
                L++;
                indexL = findIndexFromTable(s.charAt(L));
            } 
            if (R - L + 1 < min) {
                minString = s.substring(L, R + 1);
                min = R - L + 1;
            }
            if (countTable[0][indexL] >= countTable[1][indexL] && countTable[1][indexL] > 0) {
                countTable[1][indexL]--;
                count = count - 2;
                L++;
                countTable[1][index]--;
            }
        }
        return minString;
    }

    private void addToTable(char c, int[] row) {
        // [A..Z, a..z]
        int upper = c - 'A';
        int lower = c - 'a';
        if (upper < 26 && upper >= 0) {
            row[upper]++;
        } else {
            row[lower + 26]++;
        }
    }
    private int findIndexFromTable(char c) {
        int upper = c - 'A';
        int lower = c - 'a';
        if (upper < 26 && upper >= 0) {
            return upper;
        }
        return lower + 26;
    }
}