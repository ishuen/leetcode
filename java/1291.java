// 1291. Sequential Digits
// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//
// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
//
//
//
// Example 1:
//
// Input: low = 100, high = 300
// Output: [123,234]
// Example 2:
//
// Input: low = 1000, high = 13000
// Output: [1234,2345,3456,4567,5678,6789,12345]
//
//
// Constraints:
//
// 10 <= low <= high <= 10^9
//
// Runtime 0ms Beats 100.00%of users with Java
// Memory 39.98MB Beats 58.41%of users with Java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        char[] lowArr = String.valueOf(low).toCharArray();
        char[] highArr = String.valueOf(high).toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int j = lowArr.length; j <= highArr.length; j++) {
            for (int i = 1; i <= 9; i++) {
                char[] temp = new char[j];
                boolean isValid = true;
                for (int k = 0; k < j; k++) {
                    if (i + k <= 9) temp[k] = (char)((i + k) + '0');
                    else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid == false) continue;
                int num = toNum(temp);
                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        
        return list;
        
    }

    private int toNum(char[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + Character.getNumericValue(arr[i]);
        }
        return num;
    }
}
