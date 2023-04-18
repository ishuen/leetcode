// 451. Sort Characters By Frequency
// Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
//
// Example 1:
//
// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:
//
// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:
//
// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
//
//
// Constraints:
//
// 1 <= s.length <= 5 * 105
// s consists of English letters and digits.
//
// Runtime: 33 ms, faster than 15.76% of Java online submissions for Sort Characters By Frequency.
// Memory Usage: 52.3 MB, less than 5.32% of Java online submissions for Sort Characters By Frequency.
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Integer, List<Character>> countMap = new TreeMap<>();
        charMap.keySet().forEach(c -> {
            List<Character> list = countMap.getOrDefault(charMap.get(c), new LinkedList<Character>());
            list.add(c);
            countMap.put(charMap.get(c), list);
        });
        StringBuilder str = new StringBuilder();
        for (int key : countMap.keySet()) {
            List<Character> list = countMap.get(key);
            for (int i = 0; i < list.size(); i++) {
                Character c = list.get(i);
                for (int j = 0; j < key; j++) {
                    str.append(c);
                }
            }
        }
        return str.reverse().toString();
    }
}

// map key: char, value: occurance
// map key: occurance, value: list of char
// get keys from 2nd map and compose the string


// Runtime: 8 ms, faster than 90.57% of Java online submissions for Sort Characters By Frequency.
// Memory Usage: 43.3 MB, less than 7.37% of Java online submissions for Sort Characters By Frequency.
class Solution {
    public String frequencySort(String s) {
        int[][] map = new int[256][2];
        
        for (int i = 0; i < 256; ++i) {
            map[i][1] = i;
        }
        for (char c: s.toCharArray()) {
            map[c][0]++;
        }
        Arrays.sort(map, (x, y) -> Integer.compare(y[0], x[0]));
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < 256 && map[i][0] > 0; ++i) {
            for (int j = 0; j < map[i][0]; ++j) {
                str.append((char) map[i][1]);
            }
        }
        return str.toString();
    }
}

// Runtime 15 ms Beats 66.85%
// Memory 43 MB Beats 82.93%
class Solution {
    private class CharCount {
        char c;
        int count = 0;
        CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        SortedSet<CharCount> set = new TreeSet<>((a, b) -> b.count != a.count ? b.count - a.count: a.c - b.c);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character key: map.keySet()) {
            set.add(new CharCount(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        for (CharCount cc: set) {
            for (int i = 0; i < cc.count; i++) {
                sb.append(cc.c);
            }
        }
        return sb.toString();
    }
}