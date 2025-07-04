// 873. Length of Longest Fibonacci Subsequence
//
// A sequence x1, x2, ..., xn is Fibonacci-like if:
//
// n >= 3
// xi + xi+1 == xi+2 for all i + 2 <= n
// Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
//
// A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
//
//
//
// Example 1:
//
// Input: arr = [1,2,3,4,5,6,7,8]
// Output: 5
// Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
// Example 2:
//
// Input: arr = [1,3,7,11,12,14,18]
// Output: 3
// Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
//
//
// Constraints:
//
// 3 <= arr.length <= 1000
// 1 <= arr[i] < arr[i + 1] <= 109
//
// Runtime 280 ms Beats 13.17%
// Memory 44.7 MB Beats 50.90%
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        Set<Integer> nums = new HashSet<>();
        for (int num: arr) {
            nums.add(num);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                max = Math.max(max, find(arr[i], arr[j], nums));
            }
        }
        return max;
    }

    private int find(int prev, int cur, Set<Integer> nums) {
        int count = 0;
        while (nums.contains(prev + cur)) {
            if (count == 0) {
               count = 2;
            }
            int sum = prev + cur;
            prev = cur;
            cur = sum;
            count++;
        }
        return count;
    }
}

// Runtime 73 ms Beats 88.2%
// Memory 54.7 MB Beats 5.39%
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int len = arr.length;
        int[][] matrix = new int[len][len];
        for (int i = 2; i < len; i++) {
            int first = 0;
            int second = i - 1;
            while (first < second) {
                int sum = arr[first] + arr[second];
                if (sum < arr[i]) {
                    first++;
                } else if (sum > arr[i]) {
                    second--;
                } else {
                    matrix[second][i] = matrix[first][second] + 1;
                    max = Math.max(max, matrix[second][i]);
                    first++;
                    second--;
                }
            }
        }
        return max > 0 ? max + 2: 0;
    }
}
