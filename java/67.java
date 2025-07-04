// 67. Add Binary
// Given two binary strings a and b, return their sum as a binary string.
//
// Example 1:
//
// Input: a = "11", b = "1"
// Output: "100"
// Example 2:
//
// Input: a = "1010", b = "1011"
// Output: "10101"
//
//
// Constraints:
//
// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.
//
// Runtime: 4 ms, faster than 29.66% of Java online submissions for Add Binary.
// Memory Usage: 39.7 MB, less than 11.05% of Java online submissions for Add Binary.
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int temp = 0;
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                temp = temp + Character.getNumericValue(a.charAt(indexA));
                indexA--;
            }
            if (indexB >= 0) {
                temp = temp + Character.getNumericValue(b.charAt(indexB));
                indexB--;
            }
            if (temp < 2) {
                sb.insert(0, temp);
                temp = 0;
            } else if (temp == 2) {
                sb.insert(0, 0);
                temp--;
            } else {
                sb.insert(0, 1);
                temp = temp - 2;
            }
        }
        if (temp > 0) sb.insert(0, temp);
        return sb.toString();
    }
}

// Runtime: 2 ms, faster than 75.32% of Java online submissions for Add Binary.
// Memory Usage: 39.8 MB, less than 8.40% of Java online submissions for Add Binary.
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int temp = 0;
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                temp = temp + (a.charAt(indexA) - '0');
                indexA--;
            }
            if (indexB >= 0) {
                temp = temp + (b.charAt(indexB) - '0');
                indexB--;
            }
            if (temp < 2) {
                sb.insert(0, temp);
                temp = 0;
            } else if (temp == 2) {
                sb.insert(0, 0);
                temp--;
            } else {
                sb.insert(0, 1);
                temp = temp - 2;
            }
        }
        if (temp > 0) sb.insert(0, temp);
        return sb.toString();
    }
}