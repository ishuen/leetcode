// 954. Array of Doubled Pairs
//
// Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
//
//
//
// Example 1:
//
// Input: arr = [3,1,3,6]
// Output: false
// Example 2:
//
// Input: arr = [2,1,2,6]
// Output: false
// Example 3:
//
// Input: arr = [4,-2,2,-4]
// Output: true
// Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
//
//
// Constraints:
//
// 2 <= arr.length <= 3 * 104
// arr.length is even.
// -105 <= arr[i] <= 105
//
// Runtime 45 ms Beats 66.67%
// Memory 52.2 MB Beats 16.5%
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key: map.keySet()) {
            if (key != 0 && map.containsKey(key * 2)) {
                int min = Math.min(map.get(key), map.get(key * 2));
                count = count + min;
                map.put(key, map.get(key) - min);
                map.put(key * 2, map.get(2 * key) - min);
            } else if (key == 0) {
                int min = map.get(key);
                if (min % 2 == 1) return false;
                count = count + min / 2;
                map.put(key, 0);
            }
        }
        return count * 2 == arr.length;
    }
}