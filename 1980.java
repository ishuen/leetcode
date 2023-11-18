// 1980. Find Unique Binary String
//
// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
//
//
//
// Example 1:
//
// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.
// Example 2:
//
// Input: nums = ["00","01"]
// Output: "11"
// Explanation: "11" does not appear in nums. "10" would also be correct.
// Example 3:
//
// Input: nums = ["111","011","001"]
// Output: "101"
// Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 16
// nums[i].length == n
// nums[i] is either '0' or '1'.
// All the strings of nums are unique.
//
// Runtime 2ms Beats 55.09%of users with Java
// Memory 40.52MB Beats 50.91%of users with Java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int max = (int) Math.pow(2, nums[0].length());
        Set<String> set = new HashSet<>();
        for (String str: nums) {
            set.add(str);
        }
        for (int i = 0; i <= max; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            while (sb.length() < nums[0].length()) {
                sb.insert(0, '0');
            }
            if (!set.contains(sb.toString())) {
                return sb.toString();
            }
        }
        return "";
    }
}
