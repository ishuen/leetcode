// 1108. Defanging an IP Address
//
// Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
// A defanged IP address replaces every period "." with "[.]".
//
//
//
// Example 1:
//
// Input: address = "1.1.1.1"
// Output: "1[.]1[.]1[.]1"
// Example 2:
//
// Input: address = "255.100.50.0"
// Output: "255[.]100[.]50[.]0"
//
//
// Constraints:
//
// The given address is a valid IPv4 address.
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 40.62 MB Beats 33.40% of users with Java
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) == '.') {
                sb.insert(index, '[');
                sb.insert(index + 2, ']');
                index = index + 2;
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}