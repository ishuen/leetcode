// 765. Couples Holding Hands
// There are n couples sitting in 2n seats arranged in a row and want to hold hands.
//
// The people and seats are represented by an integer array row where row[i] is the ID of the person sitting in the ith seat. The couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
//
// Return the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
//
//
//
// Example 1:
//
// Input: row = [0,2,1,3]
// Output: 1
// Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
// Example 2:
//
// Input: row = [3,2,0,1]
// Output: 0
// Explanation: All couples are already seated side by side.
//
//
// Constraints:
//
// 2n == row.length
// 2 <= n <= 30
// n is even.
// 0 <= row[i] < 2n
// All the elements of row are unique.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Couples Holding Hands.
// Memory Usage: 36.5 MB, less than 67.66% of Java online submissions for Couples Holding Hands.
class Solution {
    public int minSwapsCouples(int[] row) {
        int[] partner = new int[row.length];
        int[] position = new int[row.length];
        
        for (int i = 0; i < row.length; i++) {
            partner[i] = i % 2 == 0 ? i + 1 : i - 1;
            position[row[i]] = i;
        }
        
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            int j = partner[position[partner[row[i]]]];
            while (i != j) {
                swap(row, i, j);
                swap(position, row[i], row[j]);
                count++;
                j = partner[position[partner[row[i]]]];
            }
        }
        return count;
    }
    
    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

// partner[] record where should the partner sits
// position[] reverse index of row, who occupies which seat

// if (the partner does not sit at the desired location) swap the partner's seat
// partner's ideal position = partner[row[i]]
// another person's ideal partner position = partner[position[partner[row[i]]]], j
// if (partner[position[partner[row[i]]]] != i)
// swap row[i], row[j]
// swap position[row[i]] position[row[j]]