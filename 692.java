// 692. Top K Frequent Words
// Given a non-empty list of words, return the k most frequent elements.
//
// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
// Example 1:
//
// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
//     Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:
//
// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//     with the number of occurrence being 4, 3, 2 and 1 respectively.
// Note:
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Input words contain only lowercase letters.
// Follow up:
//
// Try to solve it in O(n log k) time and O(n) extra space.

// Runtime: 12 ms, faster than 5.44% of Java online submissions for Top K Frequent Words.
// Memory Usage: 42.4 MB, less than 5.54% of Java online submissions for Top K Frequent Words.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Queue<WordCount> queue = new PriorityQueue<>((WordCount wordCount1, WordCount wordCount2) -> {
            if (wordCount1.count == wordCount2.count) {
                return wordCount1.word.compareTo(wordCount2.word);
            }
            return Integer.compare(wordCount2.count, wordCount1.count);
        });
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        map.entrySet().forEach(entry -> {
            queue.add(new WordCount(entry.getKey(), entry.getValue()));
        });
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().word);
        }
        return ans;
    }
    
    private class WordCount {
        String word;
        int count;
        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}

// Create a priority queue to sort wordCount
// class wordCount {string, int}


// Runtime: 5 ms, faster than 83.03% of Java online submissions for Top K Frequent Words.
// Memory Usage: 39.1 MB, less than 64.85% of Java online submissions for Top K Frequent Words.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((entry1, entry2) -> {
            if (entry1.getValue() == entry2.getValue()) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return Integer.compare(entry2.getValue(), entry1.getValue());
        });
        map.entrySet().forEach(entry -> queue.add(entry));
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().getKey());
        }
        return ans;
    }
}

