// 699. Falling Squares
// There are several squares being dropped onto the X-axis of a 2D plane.
//
// You are given a 2D integer array positions where positions[i] = [lefti, sideLengthi] represents the ith square with a side length of sideLengthi that is dropped with its left edge aligned with X-coordinate lefti.
//
// Each square is dropped one at a time from a height above any landed squares. It then falls downward (negative Y direction) until it either lands on the top side of another square or on the X-axis. A square brushing the left/right side of another square does not count as landing on it. Once it lands, it freezes in place and cannot be moved.
//
// After each square is dropped, you must record the height of the current tallest stack of squares.
//
// Return an integer array ans where ans[i] represents the height described above after dropping the ith square.
//
//
//
// Example 1:
//
//
// Input: positions = [[1,2],[2,3],[6,1]]
// Output: [2,5,5]
// Explanation:
// After the first drop, the tallest stack is square 1 with a height of 2.
// After the second drop, the tallest stack is squares 1 and 2 with a height of 5.
// After the third drop, the tallest stack is still squares 1 and 2 with a height of 5.
// Thus, we return an answer of [2, 5, 5].
// Example 2:
//
// Input: positions = [[100,100],[200,100]]
// Output: [100,100]
// Explanation:
// After the first drop, the tallest stack is square 1 with a height of 100.
// After the second drop, the tallest stack is either square 1 or square 2, both with heights of 100.
// Thus, we return an answer of [100, 100].
// Note that square 2 only brushes the right side of square 1, which does not count as landing on it.
//
//
// Constraints:
//
// 1 <= positions.length <= 1000
// 1 <= lefti <= 108
// 1 <= sideLengthi <= 106
//
// Runtime: 899 ms, faster than 6.21% of Java online submissions for Falling Squares.
// Memory Usage: 39.8 MB, less than 67.70% of Java online submissions for Falling Squares.
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Node> nodeList = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(positions[0][1]);
        nodeList.add(new Node(positions[0][0], positions[0][0] + positions[0][1], positions[0][1]));
        int max = positions[0][1];
        for (int i = 1; i < positions.length; i++) {
            int localMax = 0;
            for (int j = 0; j < nodeList.size(); j++) {
                Node cur = nodeList.get(j);
                if (cur.left >= positions[i][0] + positions[i][1]) continue;
                if (cur.right <= positions[i][0]) continue;
                localMax = Math.max(localMax, cur.height);
            }
            localMax += positions[i][1];
            max = Math.max(max, localMax);
            ans.add(max);
            nodeList.add(new Node(positions[i][0], positions[i][0] + positions[i][1], localMax));
        }
        return ans;
    }
    class Node{
        int left;
        int right;
        int height;
        public Node(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }
}

// Runtime: 408 ms, faster than 6.21% of Java online submissions for Falling Squares.
// Memory Usage: 39.5 MB, less than 91.93% of Java online submissions for Falling Squares.
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Node> nodeList = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(positions[0][1]);
        nodeList.add(new Node(positions[0][0], positions[0][0] + positions[0][1], positions[0][1]));
        int max = positions[0][1];
        for (int i = 1; i < positions.length; i++) {
            int localMax = 0;
            for (int j = 0; j < nodeList.size(); j++) {
                Node cur = nodeList.get(j);
                if (cur.left >= positions[i][0] + positions[i][1]) continue;
                if (cur.right <= positions[i][0]) continue;
                localMax = Math.max(localMax, cur.height);
                if (cur.left >= positions[i][0] && cur.right <= positions[i][0] + positions[i][1]) {
                    nodeList.remove(cur);
                    j--;
                }
            }
            localMax += positions[i][1];
            max = Math.max(max, localMax);
            ans.add(max);
            nodeList.add(new Node(positions[i][0], positions[i][0] + positions[i][1], localMax));
        }
        return ans;
    }
    class Node{
        int left;
        int right;
        int height;
        public Node(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }
}

// Runtime: 27 ms, faster than 36.65% of Java online submissions for Falling Squares.
// Memory Usage: 39.8 MB, less than 67.70% of Java online submissions for Falling Squares.
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 0); 
        int max = 0;
        for (int[] position : positions) {
            int start = position[0];
            int end = start + position[1];
            Integer from = heights.floorKey(start);
            int height = 0;
            for (int h: heights.subMap(from, end).values()) {
                height = Math.max(height, h);
            }
            height += position[1];
            max = Math.max(height, max);
            ans.add(max);
            int lastHeight = heights.floorEntry(end).getValue();
            heights.put(start, height);
            heights.put(end, lastHeight);
            heights.keySet().removeAll(new HashSet<>(heights.subMap(start, false, end, false).keySet()));
        }
        return ans;
    }
}

