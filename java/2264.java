// 2264. Largest 3-Same-Digit Number in String
//
// You are given a string num representing a large integer. An integer is good if it meets the following conditions:
//
// It is a substring of num with length 3.
// It consists of only one unique digit.
// Return the maximum good integer as a string or an empty string "" if no such integer exists.
//
// Note:
//
// A substring is a contiguous sequence of characters within a string.
// There may be leading zeroes in num or a good integer.
//
//
// Example 1:
//
// Input: num = "6777133339"
// Output: "777"
// Explanation: There are two distinct good integers: "777" and "333".
// "777" is the largest, so we return "777".
// Example 2:
//
// Input: num = "2300019"
// Output: "000"
// Explanation: "000" is the only good integer.
// Example 3:
//
// Input: num = "42352338"
// Output: ""
// Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
//
//
// Constraints:
//
// 3 <= num.length <= 1000
// num only consists of digits.
//
// Runtime 2 ms Beats 80.64% of users with Java
// Memory 40.96 MB Beats 68.11% of users with Java
class Solution {
    public String largestGoodInteger(String num) {
        int startPointer = 0;
        int currentPointer = 0;
        int counter = 0;
        String max = "";
        while (currentPointer < num.length()) {
            if (num.charAt(startPointer) == num.charAt(currentPointer)) {
                counter++;
                currentPointer++;
                if (counter == 3) {
                    if (max.equals("") || Character.getNumericValue(max.charAt(0)) < Character.getNumericValue(num.charAt(startPointer))) {
                        max = num.substring(startPointer, currentPointer);
                    }
                }
            } else {
                counter = 0;
                startPointer = currentPointer;
            }
        }

        return max;
    }
}


// Runtime 0 ms Beats 100.00% of users with Java
// Memory 40.57 MB Beats 90.89% of users with Java
class Solution {
    public String largestGoodInteger(String num) {
        if (num.indexOf("999") != - 1) {
            return "999";
        } else if (num.indexOf("888") != - 1) {
            return "888";
        } else if (num.indexOf("777") != - 1) {
            return "777";
        } else if (num.indexOf("666") != - 1) {
            return "666";
        } else if (num.indexOf("555") != - 1) {
            return "555";
        } else if (num.indexOf("444") != - 1) {
            return "444";
        } else if (num.indexOf("333") != - 1) {
            return "333";
        } else if (num.indexOf("222") != - 1) {
            return "222";
        } else if (num.indexOf("111") != - 1) {
            return "111";
        } else if (num.indexOf("000") != - 1) {
            return "000";
        }
        return "";
    }
}	