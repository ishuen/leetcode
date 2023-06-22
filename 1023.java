// 1023. Camelcase Matching
//
// Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
//
// A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
//
//
//
// Example 1:
//
// Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
// Output: [true,false,true,true,false]
// Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
// "FootBall" can be generated like this "F" + "oot" + "B" + "all".
// "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
// Example 2:
//
// Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
// Output: [true,false,true,false,false]
// Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
// "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
// Example 3:
//
// Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
// Output: [false,true,false,false,false]
// Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
//
//
// Constraints:
//
// 1 <= pattern.length, queries.length <= 100
// 1 <= queries[i].length <= 100
// queries[i] and pattern consist of English letters.
//
// Runtime 0 ms Beats 100%
// Memory 40.9 MB Beats 32.8%
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (String query: queries) {
            int index = 0;
            boolean result = true;
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                if (index < pattern.length() && c == pattern.charAt(index)) {
                    index++;
                } else if (c - 'a' >= 0 && c - 'a' < 26) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }
            if (index < pattern.length()) result = false;
            list.add(result);
        }
        return list;
    }
}