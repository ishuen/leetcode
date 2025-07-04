// 556. Next Greater Element III
//
// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
//
// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
//
//
//
// Example 1:
//
// Input: n = 12
// Output: 21
// Example 2:
//
// Input: n = 21
// Output: -1
//
//
// Constraints:
//
// 1 <= n <= 231 - 1
//
// Runtime 1 ms Beats 38.85%
// Memory 39.5 MB Beats 54.21%
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        int index = arr.length - 1;
        while (index > 0) {
            map.put(arr[index], map.getOrDefault(arr[index], 0) + 1);
            int prev = index - 1;
            if (arr[prev] < arr[index]) {
                char first = map.higherKey(arr[prev]);
                char temp = arr[prev];
                arr[prev] = first;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                int firstCount = map.get(first) - 1;
                if (firstCount == 0) {
                    map.remove(first);
                } else {
                    map.put(first, firstCount);
                }
                while (index < arr.length && !map.isEmpty()) {
                    char f = map.firstKey();
                    int count = map.get(f);
                    while (count > 0 && index < arr.length) {
                        arr[index] = f;
                        index++;
                        count--;
                    }
                    map.remove(f);
                }
                try {
                    return Integer.parseInt(new String(arr));
                } catch(Exception e) {
                    return -1;
                }
            } else {
                index--;
            }
        }
        return -1;
    }
}

// Runtime 0 ms Beats 100%
// Memory 39.7 MB Beats 43.72%
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int index = arr.length - 1;
        while (index > 0) {
            int prev = index - 1;
            if (arr[prev] < arr[index]) {
                char first = arr[prev];
                char min = arr[index];
                int minIndex = index;
                for (int i = index; i < arr.length; i++) {
                    if (arr[i] < min && arr[i] > first) {
                        min = arr[i];
                        minIndex = i;
                    }
                }
                arr[prev] = min;
                arr[minIndex] = first;
                Arrays.sort(arr, index, arr.length);
                try {
                    return Integer.parseInt(new String(arr));
                } catch(Exception e) {
                    return -1;
                }
            } else {
                index--;
            }
        }
        return -1;
    }
}
