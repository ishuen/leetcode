// 282. Expression Add Operators
// Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.
//
//
//
// Example 1:
//
// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Example 2:
//
// Input: num = "232", target = 8
// Output: ["2*3+2","2+3*2"]
// Example 3:
//
// Input: num = "105", target = 5
// Output: ["1*0+5","10-5"]
// Example 4:
//
// Input: num = "00", target = 0
// Output: ["0*0","0+0","0-0"]
// Example 5:
//
// Input: num = "3456237490", target = 9191
// Output: []
//
//
// Constraints:
//
// 1 <= num.length <= 10
// num consists of only digits.
// -231 <= target <= 231 - 1
//
// Runtime: 93 ms, faster than 37.09% of Java online submissions for Expression Add Operators.
// Memory Usage: 40 MB, less than 53.31% of Java online submissions for Expression Add Operators.
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (Long.valueOf(num) < target) return list;
        operate(0, 0, 0, target, num, "", list);
        return list;
    }
    
    private void operate(int start, long cur, long multiplied, int target, String num, String str, List<String> list) {
        if (start == num.length()) {
            if (cur == target) list.add(str);
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if(i != start && num.charAt(start) == '0') break;
            long n = Long.valueOf(num.substring(start, i + 1));
            if (start == 0) {
                operate(i + 1, cur + n, n, target, num, String.valueOf(n), list);
                continue;
            }
            operate(i + 1, cur + n, n, target, num, str + "+" + n, list);
            operate(i + 1, cur - n, -n, target, num, str + "-" + n, list);
            operate(i + 1, (int) (cur - multiplied + n * multiplied), n * multiplied, target, num, str + "*" + n, list);
        }
    }
}