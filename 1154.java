// 1154. Day of the Year
// Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
//
//
//
// Example 1:
//
// Input: date = "2019-01-09"
// Output: 9
// Explanation: Given date is the 9th day of the year in 2019.
// Example 2:
//
// Input: date = "2019-02-10"
// Output: 41
// Example 3:
//
// Input: date = "2003-03-01"
// Output: 60
// Example 4:
//
// Input: date = "2004-03-01"
// Output: 61
//
//
// Constraints:
//
// date.length == 10
// date[4] == date[7] == '-', and all other date[i]'s are digits
// date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
//
// Runtime: 8 ms, faster than 94.26% of Java online submissions for Day of the Year.
// Memory Usage: 39.6 MB, less than 43.34% of Java online submissions for Day of the Year.
class Solution {
    public int dayOfYear(String date) {
        int[] lastOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));
        int count = day;
        for (int i = 1; i < month; i++) {
            count += lastOfMonth[i - 1];
            if (year % 4 == 0 && i == 2) count++;
        }
        return count;
    }
}