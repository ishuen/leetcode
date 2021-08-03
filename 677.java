// 677. Map Sum Pairs
// Design a map that allows you to do the following:
//
// Maps a string key to a given value.
// Returns the sum of the values that have a key with a prefix equal to a given string.
// Implement the MapSum class:
//
// MapSum() Initializes the MapSum object.
// void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
// int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
//
//
// Example 1:
//
// Input
// ["MapSum", "insert", "sum", "insert", "sum"]
// [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
// Output
// [null, null, 3, null, 5]
//
// Explanation
// MapSum mapSum = new MapSum();
// mapSum.insert("apple", 3);
// mapSum.sum("ap");           // return 3 (apple = 3)
// mapSum.insert("app", 2);
// mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
//
//
// Constraints:
//
// 1 <= key.length, prefix.length <= 50
// key and prefix consist of only lowercase English letters.
// 1 <= val <= 1000
// At most 50 calls will be made to insert and sum.
//
// Runtime: 13 ms, faster than 18.86% of Java online submissions for Map Sum Pairs.
// Memory Usage: 39.3 MB, less than 14.55% of Java online submissions for Map Sum Pairs.
class MapSum {

    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int sub = 0;
        if (map.containsKey(key)) {
            sub = map.get(key);
        }
        map.put(key, val);
        for (int i = key.length() - 1; i > 0; i--) {
            String substr = key.substring(0, i);
            map.put('-' + substr, map.getOrDefault('-' + substr, 0) - sub + val);
        }
    }
    
    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0) + map.getOrDefault('-' + prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
 
// Runtime: 11 ms, faster than 92.20% of Java online submissions for Map Sum Pairs.
// Memory Usage: 39.1 MB, less than 47.25% of Java online submissions for Map Sum Pairs.
class MapSum {

    class Node {
        Node[] next = new Node[26];
        int sum = 0;
    }
    Map<String, Integer> map;
    Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        root = new Node();
    }
    
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        Node pointer = root;
        map.put(key, val);
        char[] arr = key.toCharArray();
        for (char c: arr) {
            if (pointer.next[c - 'a'] == null) {
                pointer.next[c - 'a'] = new Node();
            }
            pointer = pointer.next[c - 'a'];
            pointer.sum = pointer.sum + diff;
        }
    }
    
    public int sum(String prefix) {
        char[] arr = prefix.toCharArray();
        Node pointer = root;
        int sum = 0;
        for (char c: arr) {
            if (pointer.next[c - 'a'] == null) return 0;
            pointer = pointer.next[c - 'a'];
        }
        return pointer.sum;
    }
}
