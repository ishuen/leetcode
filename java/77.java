// 77. Combinations
// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
//
// You may return the answer in any order.
// Example 1:
//
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// Example 2:
//
// Input: n = 1, k = 1
// Output: [[1]]
//
//
// Constraints:
//
// 1 <= n <= 20
// 1 <= k <= n

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Combinations.
// Memory Usage: 40.4 MB, less than 45.27% of Java online submissions for Combinations.
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        List<List<Integer>> answer = new ArrayList<>();
        if (k == n) {
            answer.add(numbers);
            return answer;
        }
        combine(k, 0, numbers, new ArrayList<Integer>(), answer);
        return answer;
    }
    
    private void combine(int remained, int startIndex, List<Integer> numbers, List<Integer> tempList, List<List<Integer>> answer) {
        if (remained == 1) {
            for (int i = startIndex; i < numbers.size(); i++) {
                List<Integer> newList = new ArrayList<>(tempList);
                newList.add(numbers.get(i));
                answer.add(newList);
            }
        } else {
            for (int i = startIndex; i < numbers.size() - remained + 1; i++) {
                tempList.add(numbers.get(i));
                combine(remained - 1, i + 1, numbers, tempList, answer);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

// when k = n -> [[1..n]]
// when k < n
// prepare a list from 1 to n
// 1, 2, 3, 4; k = 2
// [1, 2], [1, 3], [1, 4]..