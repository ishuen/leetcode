// 593. Valid Square
// Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
//
// The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
//
// A valid square has four equal sides with positive length and four equal angles (90-degree angles).
//
//
//
// Example 1:
//
// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
// Output: true
// Example 2:
//
// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
// Output: false
// Example 3:
//
// Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
// Output: true
//
//
// Constraints:
//
// p1.length == p2.length == p3.length == p4.length == 2
// -104 <= xi, yi <= 104
//
// Runtime: 1 ms, faster than 87.23% of Java online submissions for Valid Square.
// Memory Usage: 36.8 MB, less than 72.21% of Java online submissions for Valid Square.
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(getLength(p1, p2));
        set.add(getLength(p1, p3));
        set.add(getLength(p1, p4));
        set.add(getLength(p2, p3));
        set.add(getLength(p2, p4));
        set.add(getLength(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }
    
    private int getLength(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}

// same length for each side
// same length for diagonals