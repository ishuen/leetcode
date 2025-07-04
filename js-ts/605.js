// 605. Can Place Flowers
//
// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
//
//
//
// Example 1:
//
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true
// Example 2:
//
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
//
//
// Constraints:
//
// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] is 0 or 1.
// There are no two adjacent flowers in flowerbed.
// 0 <= n <= flowerbed.length
//
// Runtime 53 ms Beats 80.73% of users with JavaScript
// Memory 43.90 MB Beats 77.59% of users with JavaScript
/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    let pointer = 0;
	if (n == 0) return true;
    while (pointer < flowerbed.length) {
        if (flowerbed[pointer] === 0 && (flowerbed[pointer + 1] === 0 || pointer === flowerbed.length - 1)) {
            n--;
            pointer = pointer + 2;
        } else if (flowerbed[pointer] === 1) {
            pointer = pointer + 2;
        } else {
            pointer = pointer + 1;
        }
    }
    return n <= 0;
};
