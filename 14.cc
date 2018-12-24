// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
// Input: ["flower","flow","flight"]
// Output: "fl"
// Example 2:
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
// Note:
//
// All given inputs are in lowercase letters a-z

// 4 ms, faster than 98.58%
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";
        string pre = strs[0];
        int length = strs.size();
        for (int i = 1; i < length; i++) {
            int psize = pre.size();
            if (psize == 0) break;
            int len = strs[i].size();
            if (len < psize) {
                pre = pre.substr(0, len);
            }
            for (int j = 0; j < len; j++) {
                if (pre[j] != strs[i][j]) {
                    pre = pre.substr(0, j);
                }
            }
        }
        return pre;
    }
};