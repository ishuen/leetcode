// Runtime: 19 ms, faster than 51.4% of Java online submissions for Longest Harmonious Subsequence.
// Memory Usage: 40.3 MB, less than 5.28% of Java online submissions for Longest Harmonious Subsequence.
class Solution {
    Map<Integer, Integer> map;
    public int findLHS(int[] nums) {
        map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            Integer occurrance = map.get(Integer.valueOf(num));
            if (Objects.isNull(occurrance)) {
                occurrance = 1;
            } else {
                occurrance = occurrance + 1;   
            } 
            map.put(Integer.valueOf(num),  occurrance); 
            Integer prev = map.get(Integer.valueOf(num - 1));
            Integer next = map.get(Integer.valueOf(num + 1));
            if (map.containsKey(prev)) {
                max = updateMax(max, prev, occurrance);
            }
            if (Objects.nonNull(next)) {
                max = updateMax(max, occurrance, next);
            }
        }
        return max;
    }
    private int updateMax(int oldMax, Integer givenNum1, Integer givenNum2) {
        int sum = givenNum1 + givenNum2;
        if (sum > oldMax) {
            return sum;
        }
        return oldMax;
    }
}

// Runtime: 17 ms, faster than 64.46% of Java online submissions for Longest Harmonious Subsequence.
// Memory Usage: 40.5 MB, less than 5.28% of Java online submissions for Longest Harmonious Subsequence.
class Solution {
    Map<Integer, Integer> map;
    public int findLHS(int[] nums) {
        map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            map.put(Integer.valueOf(num), map.getOrDefault(Integer.valueOf(num), 0) + 1);
        }
        for (Integer key: map.keySet()) {
            Integer occurrance = map.get(key);
            Integer next = map.get(key + 1);
            if (Objects.nonNull(next)) {
                max = updateMax(max, occurrance, next);
            }
        }
        return max;
    }
    private int updateMax(int oldMax, Integer givenNum1, Integer givenNum2) {
        int sum = givenNum1 + givenNum2;
        if (sum > oldMax) {
            return sum;
        }
        return oldMax;
    }
}