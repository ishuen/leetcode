// 844. Backspace String Compare
// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
//
//
//
// Example 1:
//
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
// Example 2:
//
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
// Example 3:
//
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".
//
//
// Constraints:
//
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.
//
//
// Runtime 2 ms Beats 64.61%
// Memory 40.7 MB Beats 61.34%
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '#') {
                if (!stackS.empty()) stackS.pop();
            } else {
                stackS.push(character);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if (character == '#') {
                if (!stackT.empty()) stackT.pop();
            } else {
                stackT.push(character);
            }
        }
        if (stackS.size() != stackT.size()) return false;
        while(!stackS.isEmpty()) {
            char topS = stackS.pop();
            char topT = stackT.pop();
            if (topS != topT) return false;
        }
        return true;
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.9 MB Beats 32.78%
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int pointerS = s.length() - 1;
        int pointerT = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (pointerS >= 0 || pointerT >= 0) {
            while(pointerS >= 0) {
                if (s.charAt(pointerS) == '#') {
                    skipS++;
                    pointerS--;
                } else if (skipS > 0) {
                    skipS--;
                    pointerS--;
                } else {
                    break;
                }
            }
            while(pointerT >= 0) {
                if (t.charAt(pointerT) == '#') {
                    skipT++;
                    pointerT--;
                } else if (skipT > 0) {
                    skipT--;
                    pointerT--;
                } else {
                    break;
                }
            }
            if (pointerS >= 0 && pointerT >= 0 && s.charAt(pointerS) != t.charAt(pointerT)) return false;
            if ((pointerS >= 0) != (pointerT >= 0)) return false;
            pointerS--;
            pointerT--;
        }
        return true;
    }