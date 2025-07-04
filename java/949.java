// 949. Largest Time for Given Digits
//
// Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
//
// 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
//
// Return the latest 24-hour time in "HH:MM" format. If no valid time can be made, return an empty string.
//
//
//
// Example 1:
//
// Input: arr = [1,2,3,4]
// Output: "23:41"
// Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
// Example 2:
//
// Input: arr = [5,5,5,5]
// Output: ""
// Explanation: There are no valid 24-hour times as "55:55" is not valid.
//
//
// Constraints:
//
// arr.length == 4
// 0 <= arr[i] <= 9
//
// Runtime 9 ms Beats 62.14%
// Memory 41.1 MB Beats 53.88%
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<int[]> permutations = new ArrayList<>();
        boolean[] used = new boolean[4];
        findPermutation(new int[4], used, arr, permutations, 0);
        if (permutations.size() == 0) return "";
        int[] max = permutations.get(0);
        for (int i = 1; i < permutations.size(); i++) {
            int[] trial = permutations.get(i);
            if (isLater(permutations.get(i), max)) {
               max = permutations.get(i);
            }
        }
        return max[0] + "" + max[1] + ":" + max[2] + "" + max[3];
    }

    private void findPermutation(int[] trial, boolean[] used, int[] arr, List<int[]> permutations, int step) {
        if (step == 4 && isValid(trial)) {
            permutations.add(new int[] {trial[0], trial[1], trial[2], trial[3]});
        }
        for (int i = 0; i < 4; i++) {
            if (used[i] == false) {
                trial[step] = arr[i];
                used[i] = true;
                findPermutation(trial, used, arr, permutations, step + 1);
                used[i] = false;
            }
        }
    }

    private boolean isValid(int[] trial) {
        int hour = trial[0] * 10 + trial[1];
        if (hour >= 24) return false;
        int minute = trial[2] * 10 + trial[3];
        return minute < 60;
    }

    private boolean isLater(int[] trial1, int[] trial2) {
        int hour1 = trial1[0] * 10 + trial1[1];
        int hour2 = trial2[0] * 10 + trial2[1];
        if (hour1 == hour2) {
            int minute1 = trial1[2] * 10 + trial1[3];
            int minute2 = trial2[2] * 10 + trial2[3];
            return minute1 > minute2;
        }
        return hour1 > hour2;
    }
}