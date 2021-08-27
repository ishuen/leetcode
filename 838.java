// 838. Push Dominoes
// There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
// After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
// For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//
// You are given a string dominoes representing the initial state where:
//
// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
// Return a string representing the final state.
//
//
//
// Example 1:
//
// Input: dominoes = "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino.
// Example 2:
//
//
// Input: dominoes = ".L.R...LR..L.."
// Output: "LL.RR.LLRRLL.."
//
//
// Constraints:
//
// n == dominoes.length
// 1 <= n <= 105
// dominoes[i] is either 'L', 'R', or '.'.
//
// Runtime: 26 ms, faster than 24.94% of Java online submissions for Push Dominoes.
// Memory Usage: 41.2 MB, less than 23.66% of Java online submissions for Push Dominoes.
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int[] disLeft = new int[dominoes.length()];
        int[] disRight = new int[dominoes.length()];
        int lastRight = -1;
        int nextLeft = dominoes.length();
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') lastRight = i;
            else if (dominoes.charAt(i) == 'L') lastRight = -1;
            if (lastRight != -1 && lastRight != i) disRight[i] = i - lastRight;
        }
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') nextLeft = i;
            else if (dominoes.charAt(i) == 'R') nextLeft = dominoes.length();
            if (nextLeft != dominoes.length() && nextLeft != i) disLeft[i] = nextLeft - i;
        }
        for (int i = 0; i < disLeft.length; i++) {
            if (disLeft[i] == disRight[i]) {
                if (disLeft[i] == 0) sb.append(dominoes.charAt(i));
                else sb.append('.');
            }
            else if (disLeft[i] < disRight[i]) {
                if (disLeft[i] == 0) sb.append('R');
                else sb.append('L');
            }
            else if (disLeft[i] > disRight[i]) {
                if (disRight[i] == 0) sb.append('L');
                else sb.append('R');
            }
        }
        return sb.toString();
    }
}

// Runtime: 27 ms, faster than 23.54% of Java online submissions for Push Dominoes.
// Memory Usage: 41.5 MB, less than 17.53% of Java online submissions for Push Dominoes.
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int len = dominoes.length();
        int[] disLeft = new int[len];
        int[] disRight = new int[len];
        int lastRight = -1;
        int nextLeft = len;
        for (int i = 0; i < len; i++) {
            if (dominoes.charAt(i) == 'R') lastRight = i;
            else if (dominoes.charAt(i) == 'L') lastRight = -1;
            if (lastRight != -1 && lastRight != i) disRight[i] = i - lastRight;
            
            if (dominoes.charAt(len - 1 - i) == 'L') nextLeft = len - 1 - i;
            else if (dominoes.charAt(len - 1 - i) == 'R') nextLeft = len;
            if (nextLeft != len && nextLeft != len - 1 - i) {
                disLeft[len - 1 - i] = nextLeft - (len - 1 - i);
            }
        }
        for (int i = 0; i < disLeft.length; i++) {
            if (disLeft[i] == disRight[i]) {
                if (disLeft[i] == 0) sb.append(dominoes.charAt(i));
                else sb.append('.');
            }
            else if (disLeft[i] < disRight[i]) {
                if (disLeft[i] == 0) sb.append('R');
                else sb.append('L');
            }
            else if (disLeft[i] > disRight[i]) {
                if (disRight[i] == 0) sb.append('L');
                else sb.append('R');
            }
        }
        return sb.toString();
    }
}
