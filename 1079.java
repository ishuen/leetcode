// 1079. Letter Tile Possibilities
//
// You have n  tiles, where each tile has one letter tiles[i] printed on it.
//
// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
//
//
//
// Example 1:
//
// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
// Example 2:
//
// Input: tiles = "AAABBC"
// Output: 188
// Example 3:
//
// Input: tiles = "V"
// Output: 1
//
//
// Constraints:
//
// 1 <= tiles.length <= 7
// tiles consists of uppercase English letters.
//
// Runtime 18 ms Beats 66.23% of users with Java
// Memory 45.42 MB Beats 8.20% of users with Java
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        char[] tileArr = tiles.toCharArray();
        StringBuilder sb = new StringBuilder();
        permutate(tileArr, sb, new boolean[tileArr.length], set);
        return set.size();
    }

    private void permutate(char[] tileArr, StringBuilder sb, boolean[] selected, Set<String> set) {
        for (int i = 0; i < tileArr.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                sb.append(tileArr[i]);
                set.add(sb.toString());
                permutate(tileArr, sb, selected, set);
                sb.deleteCharAt(sb.length() - 1);
                selected[i] = false;
            }
        }
    }
}