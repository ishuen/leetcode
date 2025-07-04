// 405. Convert a Number to Hexadecimal
//
// Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
//
// Note:
// All letters in hexadecimal (a-f) must be in lowercase.
// The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
// The given number is guaranteed to fit within the range of a 32-bit signed integer.
// You must not use any method provided by the library which converts/formats the number to hex directly.
// Example 1:
//
// Input:
// 26
//
// Output:
// "1a"
// Example 2:
//
// Input:
// -1
//
// Output:
// "ffffffff"

// Runtime: 7 ms, faster than 25.36% of Java online submissions for Convert a Number to Hexadecimal.
// Memory Usage: 37.4 MB, less than 7.26% of Java online submissions for Convert a Number to Hexadecimal.
class Solution {
    char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = arr[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
}


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert a Number to Hexadecimal.
// Memory Usage: 36.1 MB, less than 71.94% of Java online submissions for Convert a Number to Hexadecimal.
class Solution {
    char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(arr[(num & 15)]); 
            num = (num >>> 4);
        }
        return sb.reverse().toString();
    }
}