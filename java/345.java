// 345. Reverse Vowels of a String
// Given a string s, reverse only all the vowels in the string and return it.
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
//
//
//
// Example 1:
//
// Input: s = "hello"
// Output: "holle"
// Example 2:
//
// Input: s = "leetcode"
// Output: "leotcede"
//
//
// Constraints:
//
// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.
//
// Runtime: 7 ms, faster than 34.20% of Java online submissions for Reverse Vowels of a String.
// Memory Usage: 39.3 MB, less than 43.57% of Java online submissions for Reverse Vowels of a String.
class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (!vowels.contains(arr[left])) {
                left++;
            } else if (!vowels.contains(arr[right])) {
                right--;
            } else {
                swap(left, right, arr);
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
    
    private void swap(int left, int right, char[] arr) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

// Runtime: 4 ms, faster than 60.22% of Java online submissions for Reverse Vowels of a String.
// Memory Usage: 39.9 MB, less than 35.06% of Java online submissions for Reverse Vowels of a String.
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (!vowels.contains(String.valueOf(arr[left]))) {
                left++;
            } else if (!vowels.contains(String.valueOf(arr[right]))) {
                right--;
            } else {
                swap(left, right, arr);
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
    
    private void swap(int left, int right, char[] arr) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}