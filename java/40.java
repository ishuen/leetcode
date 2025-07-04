// 40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
// Each number in candidates may only be used once in the combination.
//
// Note: The solution set must not contain duplicate combinations.
// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output:
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:
//
// Input: candidates = [2,5,2,1,2], target = 5
// Output:
// [
// [1,2,2],
// [5]
// ]
//
// Constraints:
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

// Runtime: 4 ms, faster than 69.06% of Java online submissions for Combination Sum II.
// Memory Usage: 39.3 MB, less than 46.94% of Java online submissions for Combination Sum II.
class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> answerList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    dfsCombination(candidates, 0, target, path, answerList);
    return answerList;
  }
  void dfsCombination(int[] candidates, int cur, int target, LinkedList<Integer> path, List<List<Integer>> answerList) {
    if (target == 0) {
      answerList.add(new ArrayList(path));
    } else if (target > 0) {
      for (int i = cur; i < candidates.length; i++){
        if (i > cur && candidates[i] == candidates[i-1]) continue;
        path.addLast(candidates[i]);
        dfsCombination(candidates, i + 1, target - candidates[i], path, answerList);
        path.removeLast();
      }
    }
  }
}