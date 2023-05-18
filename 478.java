// 478. Generate Random Point in a Circle
//
// Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.
//
// Implement the Solution class:
//
// Solution(double radius, double x_center, double y_center) initializes the object with the radius of the circle radius and the position of the center (x_center, y_center).
// randPoint() returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array [x, y].
//
//
// Example 1:
//
// Input
// ["Solution", "randPoint", "randPoint", "randPoint"]
// [[1.0, 0.0, 0.0], [], [], []]
// Output
// [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
//
// Explanation
// Solution solution = new Solution(1.0, 0.0, 0.0);
// solution.randPoint(); // return [-0.02493, -0.38077]
// solution.randPoint(); // return [0.82314, 0.38945]
// solution.randPoint(); // return [0.36572, 0.17248]
//
//
// Constraints:
//
// 0 < radius <= 108
// -107 <= x_center, y_center <= 107
// At most 3 * 104 calls will be made to randPoint.
//
// Runtime 245 ms Beats 5.33%
// Memory 51.3 MB Beats 94.67%
class Solution {

    private Random randomX;
    private Random randomY;
    private double radius;
    private double x_center;
    private double y_center;
    public Solution(double radius, double x_center, double y_center) {
        randomX = new Random();
        randomY = new Random();
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double x = randomX.nextDouble(2 * radius) + x_center - radius;
        double y = randomY.nextDouble(2 * radius) + y_center - radius;
        while(!isInCircle(x, y)) {
            x = randomX.nextDouble(2 * radius) + x_center - radius;
            y = randomY.nextDouble(2 * radius) + y_center - radius;
        }
        return new double[]{x, y};
    }

    private boolean isInCircle(double x, double y) {
        return Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2) <= Math.pow(radius, 2);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */

// Runtime 237 ms Beats 29.33%
// Memory 51.6 MB Beats 62.67%
class Solution {

    private Random random;
    private Random randomR;
    private double radius;
    private double x_center;
    private double y_center;
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        randomR = new Random();
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double angle = random.nextDouble(2 * Math.PI);
        double r = Math.sqrt(randomR.nextDouble()) * radius;
        double x = Math.cos(angle) * r + x_center;
        double y = Math.sin(angle) * r + y_center;
        return new double[]{x, y};
    }
}
