// 165. Compare Version Numbers
// Compare two version numbers version1 and version2.
// If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
// Example 1:
//
// Input: version1 = "0.1", version2 = "1.1"
// Output: -1
// Example 2:
//
// Input: version1 = "1.0.1", version2 = "1"
// Output: 1
// Example 3:
//
// Input: version1 = "7.5.2.4", version2 = "7.5.3"
// Output: -1

// 0 ms, faster than 100.00%
class Solution {
public:
  int compareVersion(string version1, string version2) {
    int v1 = 0;
    int v2 = 0;
    int max1 = version1.size();
    int max2 = version2.size();
    int num1 = 0;
    int num2 = 0;
    while (v1 < max1 || v2 < max2) {
        while (v1 < max1 && version1[v1] != '.') {
            num1 = num1 * 10 + (version1[v1] - '0');
            v1++;
        }

        while (v2 < max2 && version2[v2] != '.') {
            num2 = num2 * 10 + (version2[v2]-'0');
            v2++;
        }
        if (num1 > num2) return 1;
        else if (num1 < num2) return -1;
        num1 = 0;
        num2 = 0;
        v1++;
        v2++;
    }
    return 0;
  }
};