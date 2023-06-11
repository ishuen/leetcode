// 967. Numbers With Same Consecutive Differences
//
// Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.
//
// Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.
//
//
//
// Example 1:
//
// Input: n = 3, k = 7
// Output: [181,292,707,818,929]
// Explanation: Note that 070 is not a valid number, because it has leading zeroes.
// Example 2:
//
// Input: n = 2, k = 1
// Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
//
//
// Constraints:
//
// 2 <= n <= 9
// 0 <= k <= 9
//
// Runtime 3 ms Beats 68.47%
// Memory 41 MB Beats 98.20%
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            sb.append(String.valueOf(i));
            getNumberString(sb, n - 1, k, list);
            sb.deleteCharAt(0);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(list.get(i));
        }
        return ans;
    }

    private void getNumberString(StringBuilder sb, int n, int k, List<String> list) {
        if (n == 0) {
            list.add(sb.toString());
            return;
        }
        int last = sb.charAt(sb.length() - 1) - '0';
        for (int i = 0; i <= 9; i++) {
            if (last + k != i && last - k != i) continue;
            sb.append(i);
            getNumberString(sb, n - 1, k, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}