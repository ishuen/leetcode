// 119. Pascal's Triangle II
// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
// Example 1:
//
// Input: rowIndex = 3
// Output: [1,3,3,1]
// Example 2:
//
// Input: rowIndex = 0
// Output: [1]
// Example 3:
//
// Input: rowIndex = 1
// Output: [1,1]
//
//
// Constraints:
//
// 0 <= rowIndex <= 33
//
//
// Runtime 1 ms Beats 78.7%
// Memory 40.5 MB Beats 41.77%
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        last.add(1);
        if (rowIndex == 0) return last;
        last.add(1);
        if (rowIndex == 1) return last;
        int count = 1;
        List<Integer> cur = new ArrayList<>();
        while (count < rowIndex) {
            cur = new ArrayList<>();
            cur.add(1);
            int index = 0;
            while(index < last.size() - 1) {
                cur.add(last.get(index) +last.get(index + 1));
                index++;
            }
            cur.add(cur.size(), 1);
            last = cur;
            count++;
        }
        return cur;
    }
}