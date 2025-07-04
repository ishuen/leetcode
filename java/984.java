// 984. String Without AAA or BBB
//
// Given two integers a and b, return any string s such that:
//
// s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
// The substring 'aaa' does not occur in s, and
// The substring 'bbb' does not occur in s.
//
//
// Example 1:
//
// Input: a = 1, b = 2
// Output: "abb"
// Explanation: "abb", "bab" and "bba" are all correct answers.
// Example 2:
//
// Input: a = 4, b = 1
// Output: "aabaa"
//
//
// Constraints:
//
// 0 <= a, b <= 100
// It is guaranteed such an s exists for the given a and b.
//
// Runtime 0 ms Beats 100%
// Memory 40.2 MB Beats 52.5%
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int countA = a;
        int countB = b;
        while (countA > 0 || countB > 0) {
            if (countA > countB) {
                if (countA > 2) {
                    sb.append("aa");
                    countA = countA - 2;
                } else {
                    sb.append('a');
                    countA = countA - 1;
                }
                if (countB > 0) {
                    sb.append('b');
                    countB = countB - 1;
                }
            } else if (countB > countA) {
                if (countB > 2) {
                    sb.append("bb");
                    countB = countB - 2;
                } else {
                    sb.append("b");
                    countB = countB - 1;
                }
                if (countA > 0) {
                    sb.append('a');
                    countA = countA - 1;
                }
            } else {
                sb.append("ab");
                countA = countA - 1;
                countB = countB - 1;
            }
        }
        return sb.toString();
    }
}