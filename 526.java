// 526. Beautiful Arrangement
// Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
//
// perm[i] is divisible by i.
// i is divisible by perm[i].
// Given an integer n, return the number of the beautiful arrangements that you can construct.
//
//
//
// Example 1:
//
// Input: n = 2
// Output: 2
// Explanation:
// The first beautiful arrangement is [1,2]:
//     - perm[1] = 1 is divisible by i = 1
//     - perm[2] = 2 is divisible by i = 2
// The second beautiful arrangement is [2,1]:
//     - perm[1] = 2 is divisible by i = 1
//     - i = 2 is divisible by perm[2] = 1
// Example 2:
//
// Input: n = 1
// Output: 1
//
//
// Constraints:
//
// 1 <= n <= 15
//
// Runtime: 70 ms, faster than 41.42% of Java online submissions for Beautiful Arrangement.
// Memory Usage: 35.8 MB, less than 50.61% of Java online submissions for Beautiful Arrangement.
class Solution {
    int count;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }
        tryArrangement(0, used, n);
        return count;
    }
    
    private void tryArrangement(int startIndex, boolean[] used, int n) {
        if (startIndex == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == false && checkArrangement(i + 1, startIndex)) {
                used[i] = true;
                tryArrangement(startIndex + 1, used, n);
                used[i] = false;
            }
        }
    }
    
    private boolean checkArrangement(int num, int index) {
        return (num % (index + 1) != 0 && (index + 1) % num != 0) ? false : true;
    }
}

// Runtime: 65 ms, faster than 65.20% of Java online submissions for Beautiful Arrangement.
// Memory Usage: 35.3 MB, less than 96.69% of Java online submissions for Beautiful Arrangement.
class Solution {
    int count;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }
        tryArrangement(0, used, n);
        return count;
    }
    
    private void tryArrangement(int startIndex, boolean[] used, int n) {
        int nextIndex = startIndex + 1;
        for (int i = 0; i < n; i++) {
            if (used[i] == false && checkArrangement(i + 1, startIndex)) {
                if (startIndex == n - 1) {
                    count++;
                    return;
                } else {
                    used[i] = true;
                    tryArrangement(nextIndex, used, n);
                    used[i] = false;
                }
            }
        }
    }
    
    private boolean checkArrangement(int num, int index) {
        return (num % (index + 1) != 0 && (index + 1) % num != 0) ? false : true;
    }
}