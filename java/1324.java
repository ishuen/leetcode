// 1324. Print Words Vertically
//
// Given a string s. Return all the words vertically in the same order in which they appear in s.
// Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
// Each word would be put on only one column and that in one column there will be only one word.
//
//
//
// Example 1:
//
// Input: s = "HOW ARE YOU"
// Output: ["HAY","ORO","WEU"]
// Explanation: Each word is printed vertically.
//  "HAY"
//  "ORO"
//  "WEU"
// Example 2:
//
// Input: s = "TO BE OR NOT TO BE"
// Output: ["TBONTB","OEROOE","   T"]
// Explanation: Trailing spaces is not allowed.
// "TBONTB"
// "OEROOE"
// "   T"
// Example 3:
//
// Input: s = "CONTEST IS COMING"
// Output: ["CIC","OSO","N M","T I","E N","S G","T"]
//
//
// Constraints:
//
// 1 <= s.length <= 200
// s contains only upper case English letters.
// It's guaranteed that there is only one space between 2 words.
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 41.21 MB Beats 18.84% of users with Java
class Solution {
    public List<String> printVertically(String s) {
        List<StringBuilder> sbList = new ArrayList<>();
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            String cur = arr[i];
            for (int j = 0; j < len; j++) {
                if (j >= sbList.size()) {
                    sbList.add(new StringBuilder());
                }
                int diff = i - sbList.get(j).length();
                for (int k = 0; k < diff; k++){
                    sbList.get(j).append(" ");
                }
                sbList.get(j).append(cur.charAt(j));
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < sbList.size(); i++) {
            ans.add(sbList.get(i).toString());
        }
        return ans;
    }
}