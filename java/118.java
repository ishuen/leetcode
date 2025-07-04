// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// Example:
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
// Memory Usage: 33.7 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<Integer> prev = new ArrayList<>(1);
    prev.add(new Integer(1));
    List<List<Integer>> ans = new ArrayList<List<Integer>>(numRows);
    if (numRows == 0) {
        return ans;
    }
    ans.add(prev);
    if (numRows == 1) {
      return ans;
    }
    for (int i = 2; i <= numRows; i++) {
      List<Integer> cur = new ArrayList<>();
      int last = prev.size() - 1;
      cur.add(prev.get(0));
      for (int j = 0; j < last; j++) {
        cur.add(prev.get(j) + prev.get(j+1));
      }
      cur.add(prev.get(last));
      ans.add(cur);
      prev = cur;
    }
    return ans;
  }
}