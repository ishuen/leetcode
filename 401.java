// 401. Binary Watch
// A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
//
// For example, the below binary watch reads "4:51".
//
//
// Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
//
// The hour must not contain a leading zero.
//
// For example, "01:00" is not valid. It should be "1:00".
// The minute must be consist of two digits and may contain a leading zero.
//
// For example, "10:2" is not valid. It should be "10:02".
//
//
// Example 1:
//
// Input: turnedOn = 1
// Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// Example 2:
//
// Input: turnedOn = 9
// Output: []
//
//
// Constraints:
//
// 0 <= turnedOn <= 10
//
// Runtime 6 ms Beats 79.43%
// Memory 41.4 MB Beats 71.24%
class Solution {
    private int[] hours = new int[]{1, 2, 4, 8};
    private int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int hourDigit = 0; hourDigit <= turnedOn; hourDigit++) {
            List<Integer> hour = getHour(hourDigit);
            List<Integer> minute = getMinute(turnedOn - hourDigit);
            if (hour.size() == 0 || minute.size() == 0) continue;
            for (Integer h: hour) {
                for (Integer m: minute) {
                    ans.add(getString(h, m));
                }
            }
        }
        return ans;
    }

    private List<Integer> getHour(int hourDigit) {
        List<Integer> list = new ArrayList<>();
        if (hourDigit > hours.length) return list;
        boolean[] selected = new boolean[hours.length];
        getHour(0, 0, hourDigit, selected, list);
        return list;
    }
    private void getHour(int curIndex, int curDigit, int hourDigit, boolean[] selected, List<Integer> list) {
        if (curDigit == hourDigit) {
            int num = 0;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i] == true) {
                    num = num + hours[i];
                }
            }
            if (num < 12) list.add(num);
        } else if (curDigit > hourDigit) return;
        else {
            for (int i = curIndex; i < selected.length; i++) {
                selected[i] = true;
                getHour(i + 1, curDigit + 1, hourDigit, selected, list);
                selected[i] = false;
            }
        }
    }

    private List<Integer> getMinute(int minuteDigit) {
        List<Integer> list = new ArrayList<>();
        if (minuteDigit > minutes.length) return list;
        boolean[] selected = new boolean[minutes.length];
        getMinute(0, 0, minuteDigit, selected, list);
        return list;
    }

    private void getMinute(int curIndex, int curDigit, int hourDigit, boolean[] selected, List<Integer> list) {
        if (curDigit == hourDigit) {
            int num = 0;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i] == true) {
                    num = num + minutes[i];
                }
            }
            if (num < 60) list.add(num);
        } else if (curDigit > hourDigit) return;
        else {
            for (int i = curIndex; i < selected.length; i++) {
                selected[i] = true;
                getMinute(i + 1, curDigit + 1, hourDigit, selected, list);
                selected[i] = false;
            }
        }
    }

    private String getString(int hour, int minute) {
        return minute >= 10 ? hour + ":"+ minute : hour + ":0"+ minute;
    }
}


// Runtime 5 ms Beats 82.10%
// Memory 41.4 MB Beats 74.67%
class Solution {
    private int[] leds = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        boolean[] selected = new boolean[leds.length];
        if (turnedOn > selected.length) return ans;
        getTime(0, 0, selected, turnedOn, ans);
        return ans;
    }
    private void getTime(int curIndex, int curDigit, boolean[] selected, int digit, List<String> list) {
        if (curDigit == digit) {
            int hour = 0;
            int minute = 0;
            for (int i = 0; i < 4; i++) {
                if (selected[i] == true) {
                    hour = hour + leds[i];
                }
            }
            for (int i = 4; i < selected.length; i++) {
                if (selected[i] == true) {
                    minute = minute + leds[i];
                }
            }
            if (hour < 12 && minute < 60) list.add(getString(hour, minute));
        } else if (curDigit > digit) return;
        else {
            for (int i = curIndex; i < selected.length; i++) {
                selected[i] = true;
                getTime(i + 1, curDigit + 1, selected, digit, list);
                selected[i] = false;
            }
        }
    }

    private String getString(int hour, int minute) {
        return minute >= 10 ? hour + ":"+ minute : hour + ":0"+ minute;
    }
}