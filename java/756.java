// 756. Pyramid Transition Matrix
// We are stacking blocks to form a pyramid. Each block has a color which is a one-letter string.
//
// We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.
//
// We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.
//
// Return true if we can build the pyramid all the way to the top, otherwise false.
//
//
//
// Example 1:
//
//
// Input: bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
// Output: true
// Explanation: The allowed stacks are shown on the right.
// Starting from the bottom (level 3), we can build "CE" on level 2 and then build "E" on level 1.
// Example 2:
//
//
// Input: bottom = "AAAA", allowed = ["AAB","AAC","BCD","BBE","DEF"]
// Output: false
// Explanation: The allowed stacks are shown on the right.
// Starting from the bottom (level 4), there are multiple ways to build level 3 but trying all the possibilites, you will get always stuck before building level 1.
//
//
// Constraints:
//
// 2 <= bottom.length <= 6
// 0 <= allowed.length <= 216
// allowed[i].length == 3
// The letters in all input strings are from the set {'A', 'B', 'C', 'D', 'E', 'F'}.
// All the values of allowed are unique.
//
// accepted approaches have similar run time..
// Runtime: 2000 ms, faster than 5.52% of Java online submissions for Pyramid Transition Matrix.
// Memory Usage: 39.2 MB, less than 53.10% of Java online submissions for Pyramid Transition Matrix.
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String triple: allowed) {
            String key = triple.substring(0, 2);
            List<Character> list = map.getOrDefault(key, new LinkedList<>());
            list.add(triple.charAt(2));
            map.put(key, list);
        }
        return checkRow(0, new StringBuilder(), bottom, map);
    }

    private boolean checkRow(int start, StringBuilder sb, String prevRow, Map<String, List<Character>> map) {
        boolean isFeasible = false;
        for (int i = start; i < prevRow.length() - 1; i++) {
            String key = prevRow.substring(i, i + 2);
            // System.out.println(key);
            if (!map.containsKey(key)) return false;
            List<Character> list = map.get(key);
            if (list.size() == 1) {
                sb.append(list.get(0));
            } else {
                for (Character c: list) {
                    sb.append(c);
                    isFeasible = isFeasible || checkRow(i + 1, sb, prevRow, map);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        if (sb.length() == prevRow.length() - 1) {
            if (sb.length() == 1) return true;
            return checkRow(0, new StringBuilder(), sb.toString(), map);
        }
        return isFeasible;
    }
}
