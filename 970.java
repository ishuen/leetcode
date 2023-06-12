// 970. Powerful Integers
//
// Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
//
// An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
//
// You may return the answer in any order. In your answer, each value should occur at most once.
//
//
//
// Example 1:
//
// Input: x = 2, y = 3, bound = 10
// Output: [2,3,4,5,7,9,10]
// Explanation:
// 2 = 20 + 30
// 3 = 21 + 30
// 4 = 20 + 31
// 5 = 21 + 31
// 7 = 22 + 31
// 9 = 23 + 30
// 10 = 20 + 32
// Example 2:
//
// Input: x = 3, y = 5, bound = 15
// Output: [2,4,6,8,10,14]
//
//
// Constraints:
//
// 1 <= x, y <= 100
// 0 <= bound <= 106
//
// Runtime 1 ms Beats 100%
// Memory 40.5 MB Beats 67.46%
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        if (bound == 0) return new ArrayList(ans);
        List<Integer> xlist = new ArrayList<>();
        List<Integer> ylist = new ArrayList<>();
        int baseX = 1;
        int baseY = 1;
        xlist.add(baseX);
        while (x > 1 && baseX * x < bound) {
            baseX = baseX * x;
            xlist.add(baseX);
        }
        ylist.add(baseY);
        while (y > 1 && baseY * y < bound) {
            baseY = baseY * y;
            ylist.add(baseY);
        }
        
        for (int i = 0; i < xlist.size(); i++) {
            for (int j = 0; j < ylist.size(); j++) {
                int sum = xlist.get(i) + ylist.get(j);
                if (sum <= bound) {
                    ans.add(sum);
                } else {
                    break;
                }
            }
        }
        return new ArrayList(ans);
    }
}