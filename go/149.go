// 149. Max Points on a Line


// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

// Example 1:


// Input: points = [[1,1],[2,2],[3,3]]
// Output: 3
// Example 2:


// Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
// Output: 4
 

// Constraints:

// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.

// Runtime 8 ms Beats 82.08%
// Memory 8.65 MB Beats 37.74%
func maxPoints(points [][]int) int {
    length := len(points)
    if length < 3 {
        return length
    }
    maxCount := 0
    for i := 0; i < length; i++ {
        counts := make(map[float64]int)
        for j := i + 1; j < length; j++ {
            dx := points[i][0] - points[j][0]
            dy := points[i][1] - points[j][1]
            slope := math.MaxFloat32
            if dx != 0 {
                slope = float64(dy)/float64(dx)
            }
            counts[slope]++
        }
        for _, count := range counts {
            if count > maxCount {
                maxCount = count
            }
        }
    }
    return maxCount + 1
}