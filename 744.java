// 744. Find Smallest Letter Greater Than Target
//
// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
//
// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//
//
//
// Example 1:
//
// Input: letters = ["c","f","j"], target = "a"
// Output: "c"
// Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
// Example 2:
//
// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
// Example 3:
//
// Input: letters = ["x","x","y","y"], target = "z"
// Output: "x"
// Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
//
//
// Constraints:
//
// 2 <= letters.length <= 104
// letters[i] is a lowercase English letter.
// letters is sorted in non-decreasing order.
// letters contains at least two different characters.
// target is a lowercase English letter.
//
// Runtime 0ms Beats 100.00%of users with Java
// Memory 44.65MB Beats 8.82%of users with Java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int index = 0;
        while (left <= right && index >= 0) {
            index = (left + right) / 2;
            if (index > 0 && letters[index - 1] <= target && letters[index] > target) {
                return letters[index];
            } else if (letters[index] <= target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return letters[0];
    }
}