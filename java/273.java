// 273. Integer to English Words
// Convert a non-negative integer num to its English words representation.
//
// Example 1:
//
// Input: num = 123
// Output: "One Hundred Twenty Three"
// Example 2:
//
// Input: num = 12345
// Output: "Twelve Thousand Three Hundred Forty Five"
// Example 3:
//
// Input: num = 1234567
// Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// Example 4:
//
// Input: num = 1234567891
// Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
//
//
// Constraints:
//
// 0 <= num <= 231 - 1
//
// Runtime: 10 ms, faster than 56.08% of Java online submissions for Integer to English Words.
// Memory Usage: 39.4 MB, less than 20.35% of Java online submissions for Integer to English Words.
class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] separator = new String[]{"Billion", "Million", "Thousand"};
        String hundred = "Hundred";
        String[] twenty = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] one = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        StringBuilder sb = new StringBuilder();
        int separatorCount = 0;
        while(num > 0) {
            int temp = num % 1000;
            int t = temp % 100;
            if (t > 0 && t < 20) sb.insert(0, one[t - 1] + " ");
            else if (t > 0) {
                String digit = t % 10 == 0 ? "" : one[t % 10 - 1] + " ";
                sb.insert(0, twenty[t / 10 - 2] + " " + digit);
            }
            int h = temp / 100;
            if (h > 0) sb.insert(0, one[h - 1] + " " + hundred + " ");
            num = num / 1000;
            if (num % 1000 > 0) {
                sb.insert(0, separator[2 - separatorCount] + " ");
            }
            separatorCount++;
        }
        return sb.substring(0, sb.length() - 1);
    }
}

// max 2 B
// separate by thousand
// hundred
