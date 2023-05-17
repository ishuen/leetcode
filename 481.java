// 481. Magical String
//
// A magical string s consists of only '1' and '2' and obeys the following rules:
//
// The string s is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string s itself.
// The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". You can see that the occurrence sequence is s itself.
//
// Given an integer n, return the number of 1's in the first n number in the magical string s.
//
//
//
// Example 1:
//
// Input: n = 6
// Output: 3
// Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.
// Example 2:
//
// Input: n = 1
// Output: 1
//
//
// Constraints:
//
// 1 <= n <= 105
//
// Runtime 17 ms Beats 56.30%
// Memory 42 MB Beats 36.97%
class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int index = 2;
        while(sb.length() < n) {
            char last = sb.charAt(sb.length() - 1);
            int next = 3 - (last - '0');
            char c = (char)('0' + next);
            // System.out.println("L" + last + " " + next + " " + c);
            int repeat = sb.charAt(index) - '0';
            // System.out.println(c + " " + repeat);
            for (int i = 0; i < repeat; i++) {
                sb.append(c);
            }
            index++;
        }
        // System.out.println(sb.toString());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') count++;
        }
        return count;
    }
}

// Runtime 14 ms Beats 59.66%
// Memory 42.1 MB Beats 34.45%
class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int index = 2;
        int count = 1;
        while(sb.length() < n) {
            int last = sb.charAt(sb.length() - 1) - '0';
            char c = (char)('0' + (3 - last));
            int repeat = sb.charAt(index) - '0';
            for (int i = 0; i < repeat; i++) {
                sb.append(c);
            }
            if (c == '1') count = count + repeat;
            index++;
        }
        
        for (int i = sb.length() - 1; i >= n; i--) {
            if (sb.charAt(i) == '1') count--;
        }
        return count;
    }
}