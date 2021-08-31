// 777. Swap Adjacent in LR String
// In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
//
//
//
// Example 1:
//
// Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
// Output: true
// Explanation: We can transform start to end following these steps:
// RXXLRXRXL ->
// XRXLRXRXL ->
// XRLXRXRXL ->
// XRLXXRRXL ->
// XRLXXRRLX
// Example 2:
//
// Input: start = "X", end = "L"
// Output: false
// Example 3:
//
// Input: start = "LLR", end = "RRL"
// Output: false
// Example 4:
//
// Input: start = "XL", end = "LX"
// Output: true
// Example 5:
//
// Input: start = "XLLR", end = "LXLX"
// Output: false
//
//
// Constraints:
//
// 1 <= start.length <= 104
// start.length == end.length
// Both start and end will only consist of characters in 'L', 'R', and 'X'.
//
// Runtime: 5 ms, faster than 62.99% of Java online submissions for Swap Adjacent in LR String.
// Memory Usage: 39.7 MB, less than 17.93% of Java online submissions for Swap Adjacent in LR String.
class Solution {
    public boolean canTransform(String start, String end) {
        String s = start.replace("X", "");
        String e = end.replace("X", "");
        if (!s.equals(e)) return false;
        
        int indexS = 0;
        int indexE = 0;
        while (indexS < start.length()) {
            while (indexS < start.length() && start.charAt(indexS) == 'X') {
                indexS++;
            }
            while (indexE < end.length() && end.charAt(indexE) == 'X') {
                indexE++;
            }
            if (indexS == indexE && indexS == start.length()) return true;
            if (indexS == start.length() || indexE == end.length()) return false;
            if (start.charAt(indexS) == 'R' && indexS > indexE) return false;
            if (start.charAt(indexS) == 'L' && indexS < indexE) return false;
            indexS++;
            indexE++;
        }
        return true;
    }
}

// XXXXL -> XXXLX -> XXLXX -> XLXXX -> LXXXX
// RX -> XR

// "RXXLRXRXL"
// RLRRL
// RLRRL