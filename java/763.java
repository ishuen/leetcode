// 763. Partition Labels
// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
// Return a list of integers representing the size of these parts.
//
//
//
// Example 1:
//
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
// Example 2:
//
// Input: s = "eccbbbbdec"
// Output: [10]
//
//
// Constraints:
//
// 1 <= s.length <= 500
// s consists of lowercase English letters.
//
// Runtime: 16 ms, faster than 6.64% of Java online submissions for Partition Labels.
// Memory Usage: 40.3 MB, less than 5.32% of Java online submissions for Partition Labels.
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] count = counts.getOrDefault(c, new int[]{i, i});
            count[1] = i;
            counts.put(c, count);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] pair : counts.values()) {
            pq.add(pair);
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] base = pq.remove();
            while (!pq.isEmpty() && pq.peek()[0] < base[1]) {
                int[] top = pq.remove();
                if (top[1] > base[1]) base[1] = top[1];
            }
            ans.add(base[1] - base[0] + 1);
        }
        return ans;
    }
}

// Runtime: 6 ms, faster than 31.73% of Java online submissions for Partition Labels.
// Memory Usage: 40.1 MB, less than 5.32% of Java online submissions for Partition Labels.
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndexes[c - 'a'] = i;
        }
        int start = 0;
        int last = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastIndexes[s.charAt(i) - 'a']);
            if (i == last) {
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        return ans;
    }
}