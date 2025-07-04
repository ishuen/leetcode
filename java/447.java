// 447. Number of Boomerangs
// You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
//
// Return the number of boomerangs.
//
//
//
// Example 1:
//
// Input: points = [[0,0],[1,0],[2,0]]
// Output: 2
// Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
// Example 2:
//
// Input: points = [[1,1],[2,2],[3,3]]
// Output: 2
// Example 3:
//
// Input: points = [[1,1]]
// Output: 0
//
//
// Constraints:
//
// n == points.length
// 1 <= n <= 500
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.
//
// Runtime: 115 ms, faster than 64.55% of Java online submissions for Number of Boomerangs.
// Memory Usage: 46.7 MB, less than 28.73% of Java online submissions for Number of Boomerangs.
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        long[][] distance = new long[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                distance[i][j] = (long) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
            }
        }
        Map<Long, Integer> counting = new HashMap<>();
        int count = 0;
        int permutation = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                counting.put(distance[i][j], counting.getOrDefault(distance[i][j], 0) + 1);
            }
            Iterator it = counting.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<Long, Integer> entry = (Map.Entry) it.next();
                int occurrance = entry.getValue();
                if (occurrance <= 1) continue;
                permutation = occurrance * (occurrance - 1);
                count = count + permutation;
                permutation = 1;
            }
            counting.clear();
        }
        return count;
    }
}

// Runtime: 105 ms, faster than 67.91% of Java online submissions for Number of Boomerangs.
// Memory Usage: 39.3 MB, less than 32.84% of Java online submissions for Number of Boomerangs.
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        long distance = 0L;
        Map<Long, Integer> counting = new HashMap<>();
        int count = 0;
        int permutation = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                distance = (long) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                counting.put(distance, counting.getOrDefault(distance, 0) + 1);
            }
            Iterator it = counting.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<Long, Integer> entry = (Map.Entry) it.next();
                int occurrance = entry.getValue();
                if (occurrance <= 1) continue;
                permutation = occurrance * (occurrance - 1);
                count = count + permutation;
            }
            counting.clear();
        }
        return count;
    }
}

