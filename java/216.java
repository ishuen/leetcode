// 216. Combination Sum III
// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//
//
// Example 1:
//
// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:
//
// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
// Example 3:
//
// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// Example 4:
//
// Input: k = 3, n = 2
// Output: []
// Explanation: There are no valid combinations.
// Example 5:
//
// Input: k = 9, n = 45
// Output: [[1,2,3,4,5,6,7,8,9]]
// Explanation:
// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
// There are no other valid combinations.
//
//
// Constraints:
//
// 2 <= k <= 9
// 1 <= n <= 60
//
// Runtime: 1 ms, faster than 23.09% of Java online submissions for Combination Sum III.
// Memory Usage: 36.8 MB, less than 35.80% of Java online submissions for Combination Sum III.
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45) return new ArrayList<>();
        int minSum = 0;
        for (int i = 1; i <= k; i++) {
            minSum += i;
        }
        if (n < minSum) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }
    private void combinationSum(int k, int remained, int start, List<Integer> tempList, List<List<Integer>> ans) {
        if (remained == 0 && tempList.size() == k) {
            ans.add(new ArrayList<>(tempList));
        } else if (remained > 0 && tempList.size() < k) {
            for (int i = start; i <= 9; i++) {
                if (i <= remained) {
                    if (tempList.contains(i) == false) {
                        tempList.add(i);
                        combinationSum(k, remained - i, i + 1, tempList, ans);
                        tempList.remove(tempList.indexOf(i));
                    }
                    
                }
            }
        }
    }
}

// [1 .. 9]
// if n > 45 x
// if n < min k x
// remained <= 0, size < k