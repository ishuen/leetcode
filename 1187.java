// 1187. Make Array Strictly Increasing
//
// Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.
//
// In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].
//
// If there is no way to make arr1 strictly increasing, return -1.
//
//
//
// Example 1:
//
// Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
// Output: 1
// Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
// Example 2:
//
// Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
// Output: 2
// Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
// Example 3:
//
// Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
// Output: -1
// Explanation: You can't make arr1 strictly increasing.
//
//
// Constraints:
//
// 1 <= arr1.length, arr2.length <= 2000
// 0 <= arr1[i], arr2[i] <= 10^9
//
// Runtime 25ms Beats 97.84%of users with Java
// Memory 62.19MB Beats 72.43%of users with Java
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num: arr2) {
            set.add(num);
        }
        int len = arr1.length;
        int steps = Math.min(set.size(), len);
        int[][] matrix = new int[len + 1][steps + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        matrix[0][0] = -1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= steps; j++) {
				if (i < j) continue;
                if (arr1[i - 1] > matrix[i - 1][j]) {
                    matrix[i][j] = arr1[i - 1];
                }
                if (j > 0 && matrix[i - 1][j - 1] != Integer.MAX_VALUE) {
                    Integer replacement = set.higher(matrix[i - 1][j - 1]);
                    if (replacement != null) {
                        matrix[i][j] = Math.min(matrix[i][j], replacement);
                    }
                }
                if (i == len && matrix[i][j] != Integer.MAX_VALUE) return j;
            }
        }
        return -1;
    }
}