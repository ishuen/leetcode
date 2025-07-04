// 773. Sliding Puzzle
// On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
//
// Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
//
// Examples:
//
// Input: board = [[1,2,3],[4,0,5]]
// Output: 1
// Explanation: Swap the 0 and the 5 in one move.
// Input: board = [[1,2,3],[5,4,0]]
// Output: -1
// Explanation: No number of moves will make the board solved.
// Input: board = [[4,1,2],[5,0,3]]
// Output: 5
// Explanation: 5 is the smallest number of moves that solves the board.
// An example path:
// After move 0: [[4,1,2],[5,0,3]]
// After move 1: [[4,1,2],[0,5,3]]
// After move 2: [[0,1,2],[4,5,3]]
// After move 3: [[1,0,2],[4,5,3]]
// After move 4: [[1,2,0],[4,5,3]]
// After move 5: [[1,2,3],[4,5,0]]
// Input: board = [[3,2,4],[1,5,0]]
// Output: 14
// Note:
//
// board will be a 2 x 3 array as described above.
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
//
// Runtime: 755 ms, faster than 5.13% of Java online submissions for Sliding Puzzle.
// Memory Usage: 140.3 MB, less than 5.72% of Java online submissions for Sliding Puzzle.
class Solution {
    private Map<String, Integer> records;
    public int slidingPuzzle(int[][] board) {
        records = new HashMap<>();
        String base = "123450";
        collectPermutation(base, 0);
        return records.getOrDefault(format(board), -1);
    }
    private void collectPermutation(String key, int step) {
        int count = records.getOrDefault(key, Integer.MAX_VALUE);
        if (count >= step) {
            // System.out.println(key + " " + step);
            records.put(key, step);
            step++;
            for (int i = 0; i < 4; i++) {
                collectPermutation(swap(key, i), step);
            }
        }
    }
    private String swap(String key, int direction) {
        // 0: up, 1: left, 2: down, 3: right 
        int index = key.indexOf('0');
        StringBuilder sb = new StringBuilder(key);
        String temp = sb.substring(index, index + 1);
        if (direction == 0 && index > 2) {
            sb.replace(index, index + 1, sb.substring(index - 3, index - 2));
            sb.replace(index - 3, index - 2, temp);
        } else if (direction == 1 && index != 0 && index != 3) {
            sb.replace(index, index + 1, sb.substring(index - 1, index));
            sb.replace(index - 1, index, temp);
        } else if (direction == 2 && index < 3) {
            sb.replace(index, index + 1, sb.substring(index + 3, index + 4));
            sb.replace(index + 3, index + 4, temp);
        } else if (direction == 3 && index != 2 && index != 5) {
            sb.replace(index, index + 1, sb.substring(index + 1, index + 2));
            sb.replace(index + 1, index + 2, temp);
        }
        return sb.toString();
    }
    private String format(int[][] board) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
            }
        }
        return str.toString();
    }
}

// Runtime: 7 ms, faster than 73.57% of Java online submissions for Sliding Puzzle.
// Memory Usage: 39.1 MB, less than 31.31% of Java online submissions for Sliding Puzzle.
class Solution {
    private Map<String, Integer> records;
    public int slidingPuzzle(int[][] board) {
        String base = "123450";
        String start = format(board);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(base)) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    String next = swap(cur, j);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
    }
    private String swap(String key, int direction) {
        // 0: up, 1: left, 2: down, 3: right 
        int index = key.indexOf('0');
        StringBuilder sb = new StringBuilder(key);
        String temp = sb.substring(index, index + 1);
        if (direction == 0 && index > 2) {
            sb.replace(index, index + 1, sb.substring(index - 3, index - 2));
            sb.replace(index - 3, index - 2, temp);
        } else if (direction == 1 && index != 0 && index != 3) {
            sb.replace(index, index + 1, sb.substring(index - 1, index));
            sb.replace(index - 1, index, temp);
        } else if (direction == 2 && index < 3) {
            sb.replace(index, index + 1, sb.substring(index + 3, index + 4));
            sb.replace(index + 3, index + 4, temp);
        } else if (direction == 3 && index != 2 && index != 5) {
            sb.replace(index, index + 1, sb.substring(index + 1, index + 2));
            sb.replace(index + 1, index + 2, temp);
        }
        return sb.toString();
    }
    private String format(int[][] board) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
            }
        }
        return str.toString();
    }   
}
