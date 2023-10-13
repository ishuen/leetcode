// 1138. Alphabet Board Path
// On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
//
// Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
//
//
//
// We may make the following moves:
//
// 'U' moves our position up one row, if the position exists on the board;
// 'D' moves our position down one row, if the position exists on the board;
// 'L' moves our position left one column, if the position exists on the board;
// 'R' moves our position right one column, if the position exists on the board;
// '!' adds the character board[r][c] at our current position (r, c) to the answer.
// (Here, the only positions that exist on the board are positions with letters on them.)
//
// Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
//
//
//
// Example 1:
//
// Input: target = "leet"
// Output: "DDR!UURRR!!DDD!"
// Example 2:
//
// Input: target = "code"
// Output: "RR!DDRR!UUL!R!"
//
//
// Constraints:
//
// 1 <= target.length <= 100
// target consists only of English lowercase letters.
//
// Runtime 1ms Beats 49.66%of users with Java
// Memory 40.32MB Beats 71.43%of users with Java
class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Loc> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i), new Loc(i / 5, i % 5));
        }
        Character start = 'a';
        Loc startLoc = map.get(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
			Loc endLoc;
			if (c == 'z' && start != 'z') {
			    endLoc = map.get('u'); 
			} else {
			    endLoc = map.get(c);
            }
            int x = endLoc.x - startLoc.x;
            int y = endLoc.y - startLoc.y;
            if (x > 0) {
               for (int j = 0; j < x; j++) {
                   sb.append('D');
               } 
            } else if (x < 0) {
                for (int j = x; j < 0; j++) {
                   sb.append('U');
               } 
            }
            if (y > 0) {
                for (int j = 0; j < y; j++) {
                   sb.append('R');
                } 
            } else if (y < 0) {
                for (int j = y; j < 0; j++) {
                   sb.append('L');
                } 
            }
            if (c == 'z' && start != 'z') {
               sb.append('D'); 
               endLoc = map.get('z');
            } 
            sb.append('!');
            start = c;
            startLoc = endLoc;
        }
        return sb.toString();
    }

    public class Loc {
        int x = 0;
        int y = 0;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}