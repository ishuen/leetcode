// 823. Binary Trees With Factors
//
// Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
//
// We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
//
// Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: arr = [2,4]
// Output: 3
// Explanation: We can make these trees: [2], [4], [4, 2, 2]
// Example 2:
//
// Input: arr = [2,4,5,10]
// Output: 7
// Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
//
//
// Constraints:
//
// 1 <= arr.length <= 1000
// 2 <= arr[i] <= 109
// All the values of arr are unique.
//
// Runtime 30 ms Beats 66.88%
// Memory 42.4 MB Beats 57.50%
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> numberOfFactors = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            numberOfFactors.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && numberOfFactors.containsKey(arr[i]/ arr[j])) {
                    numberOfFactors.put(arr[i], numberOfFactors.get(arr[i]) + numberOfFactors.get(arr[j]) * numberOfFactors.get(arr[i]/ arr[j]));
                }
            }
            sum = sum + numberOfFactors.get(arr[i]);
        }
        return (int) (sum % 1000000007);
    }
}

// Runtime 29 ms Beats 79.38%
// Memory 42.6 MB Beats 36.88%
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> numberOfFactors = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long cur = 1L;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && numberOfFactors.containsKey(arr[i]/ arr[j])) {
                    cur = cur + numberOfFactors.get(arr[j]) * numberOfFactors.get(arr[i]/ arr[j]);
                }
            }
            numberOfFactors.put(arr[i], cur);
            sum = sum + cur;
        }
        return (int) (sum % 1000000007);
    }
}
