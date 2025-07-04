// 372. Super Pow
// Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
//
//
//
// Example 1:
//
// Input: a = 2, b = [3]
// Output: 8
// Example 2:
//
// Input: a = 2, b = [1,0]
// Output: 1024
// Example 3:
//
// Input: a = 1, b = [4,3,3,8,5,2]
// Output: 1
//
//
// Constraints:
//
// 1 <= a <= 231 - 1
// 1 <= b.length <= 2000
// 0 <= b[i] <= 9
// b does not contain leading zeros.
//
// Runtime 6 ms Beats 63.94%
// Memory 42.5 MB Beats 70.26%
class Solution {
    private int base = 1337;
    public int superPow(int a, int[] b) {
        int aMod = a % 1337;
        if (aMod <= 1) return aMod;
        return superPow(aMod, b, b.length - 1);
    }

    private int superPow(int a, int[] b, int end) {
        if (end < 0) return 1; 
        return pow(superPow(a, b, end - 1), 10) * pow(a, b[end]) % base;
    }
    private int pow (int a, int b) {
        if (b == 0) return 1;
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans = (ans * a) % base;
        }
        return ans;
    }
}