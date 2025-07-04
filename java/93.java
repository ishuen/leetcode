// 93. Restore IP Addresses
// Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
//
// A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//
//
//
// Example 1:
//
// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
// Example 2:
//
// Input: s = "0000"
// Output: ["0.0.0.0"]
// Example 3:
//
// Input: s = "1111"
// Output: ["1.1.1.1"]
// Example 4:
//
// Input: s = "010010"
// Output: ["0.10.0.10","0.100.1.0"]
// Example 5:
//
// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
// Constraints:
//
// 0 <= s.length <= 3000
// s consists of digits only.
//
// Runtime: 8 ms, faster than 21.77% of Java online submissions for Restore IP Addresses.
// Memory Usage: 39.2 MB, less than 64.45% of Java online submissions for Restore IP Addresses.
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        for (int i = 1; i < s.length() - 2; i++) {
            String first = s.substring(0, i);
            if (!isValid(first)) continue;
            for (int j = i + 1; j < s.length() - 1; j++) {
                String second = s.substring(i, j);
                if (!isValid(second)) continue;
                for (int k = j + 1; k < s.length(); k++) {
                    String third = s.substring(j, k);
                    String fourth = s.substring(k);
                    if (isValid(third) && isValid(fourth)) {
                        ans.add(first + "." + second + "." + third + "." + fourth);
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(String str) {
        if (str.length() > 3) return false;
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        int value = Integer.parseInt(str);
        return value >= 0 && value < 256;
    }
}