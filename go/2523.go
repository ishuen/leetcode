// 2523. Closest Prime Numbers in Range

// Given two positive integers left and right, find the two integers num1 and num2 such that:

// left <= num1 < num2 <= right .
// Both num1 and num2 are prime numbers.
// num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
// Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

 

// Example 1:

// Input: left = 10, right = 19
// Output: [11,13]
// Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
// The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
// Since 11 is smaller than 17, we return the first pair.
// Example 2:

// Input: left = 4, right = 6
// Output: [-1,-1]
// Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 

// Constraints:

// 1 <= left <= right <= 106

// Runtime 65 ms Beats 80.95%
// Memory 16.88 MB Beats 33.33%
func getPrimeList(left int, right int) []int {
    primeList := make([]bool, right + 1)
    for i := range primeList {
        primeList[i] = true
    }
    primeList[1] = false
    for i := 2; i * i <= right; i++ {
        if primeList[i] == true {
            for j := i * i; j <= right; j = j + i {
                primeList[j] = false
            }
        }
    }
    list := []int{}
    for i := left; i <= right; i++ {
        if primeList[i] == true {
            list = append(list, i)
        }
    }
    return list
}

func findMinGap(list []int) []int {
    if len(list) < 2 {
        return []int{-1, -1}
    }
    first := list[0]
    second := list[1]
    minDiff := second - first
    for i := 2; i < len(list); i++ {
        if list[i] - list[i - 1] < minDiff {
            minDiff = list[i] - list[i - 1]
            first = list[i - 1]
            second = list[i]
        }
    }
    return []int{first, second}
}

func closestPrimes(left int, right int) []int {
    list := getPrimeList(left, right)
    return findMinGap(list)
}