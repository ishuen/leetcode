// 1300. Sum of Mutated Array Closest to Target
//
// Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
//
// In case of a tie, return the minimum such integer.
//
// Notice that the answer is not neccesarilly a number from arr.
//
//
//
// Example 1:
//
// Input: arr = [4,9,3], target = 10
// Output: 3
// Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
// Example 2:
//
// Input: arr = [2,3,5], target = 10
// Output: 5
// Example 3:
//
// Input: arr = [60864,25176,27249,21296,20204], target = 56803
// Output: 11361
//
//
// Constraints:
//
// 1 <= arr.length <= 104
// 1 <= arr[i], target <= 105
//
// Runtime 1710ms Beats 5.24%of users with Java
// Memory 42.64MB Beats 96.67%of users with Java
class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        int base = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        int minDis = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        while (base >= 0) {
            int dis = Math.abs(sum - target);
            if (dis < minDis) {
                minDis = dis;
                best = base;
            } else if (dis == minDis) {
                best = Math.min(base, best);
            }
            base--;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > base) {
                    sum = sum - (arr[i] - base);
                    arr[i] = base;
                } else {
                    break;
                }
            }
        }
        return best;
    }
}


// Runtime 2ms Beats 97.14%of users with Java
// Memory 42.97MB Beats 78.57%of users with Java
class Solution {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return search(0, target, arr, target, sum);
    }

    private int getSum(int[] arr, int base) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > base) {
                sum = sum + base;
            } else {
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    private int search(int min, int max, int[] arr, int target, int sum) {
        if (min == max) return min;
        if (min + 1 == max) {
            if (Math.abs(target - getSum(arr, min)) <= Math.abs(target - getSum(arr, max))) {
                return min;
            }
            return max;
        }
        int mid = (min + max) / 2;
        int midSum = getSum(arr, mid);
        if (midSum >= target || sum == midSum) {
            return search(min, mid, arr, target, sum);
        }
        return search(mid, max, arr, target, sum);
    }
}