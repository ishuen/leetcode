// 1002. Find Common Characters
// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
// Example 1:
// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
//
// Example 2:
// Input: ["cool","lock","cook"]
// Output: ["c","o"]
//
// Note:
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] is a lowercase letter



// Runtime: 2 ms, faster than 96.84% of Java online submissions for Find Common Characters.
// Memory Usage: 39.6 MB, less than 65.02% of Java online submissions for Find Common Characters.
class Solution {
  public List<String> commonChars(String[] A) {
    int[] base = new int[26];
    for (char c: A[0].toCharArray()) {
      base[c - 'a']++;
    }
    for (int i = 1; i < A.length; i++) {
      int[] temp = new int[26];
      for (char c: A[i].toCharArray()) {
        temp[c - 'a']++;
      }
      for (int j = 0; j < 26; j++) {
        base[j] = Math.min(temp[j], base[j]);
      }
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (base[i] > 0) {
        for (int j = 0; j < base[i]; j++) {
          ans.add(Character.toString((char) ('a' + i)));
        }
      }
    }
    return ans;
  }
}