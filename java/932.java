// 932. Beautiful Array
//
// An array nums of length n is beautiful if:
//
// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
// Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.
//
//
//
// Example 1:
//
// Input: n = 4
// Output: [2,1,4,3]
// Example 2:
//
// Input: n = 5
// Output: [3,1,2,5,4]
//
//
// Constraints:
//
// 1 <= n <= 1000
//
// Runtime 6 ms Beats 18.69%
// Memory 41.3 MB Beats 99.7%
class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : res) {
                if (i * 2 - 1 <= n) temp.add(i * 2 - 1);
            }
            for (int i : res) {
                if (i * 2 <= n) temp.add(i * 2);
            }
            res = temp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}

// A = [2, 1, 4, 5, 3]
// A1 (odd number conversion from A) = [3, 1, 7, 9, 5]
// A2 (even number conversion from A) = [4, 2, 8, 10, 6]
// B = A1 + A2 = [3, 1, 7, 9, 5, 4, 2, 8, 10, 6]