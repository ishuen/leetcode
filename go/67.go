// 67. Add Binary

// Given two binary strings a and b, return their sum as a binary string.

 

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"
 

// Constraints:

// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.

// Runtime 0 ms Beats 100.00%
// Memory 5.51 MB Beats 25.35%
func addBinary(a string, b string) string {
    indexA := len(a) - 1
    indexB := len(b) - 1
    next := 0
    output := ""
    digit := 0
    for ; indexA >= 0 && indexB >= 0; {
        if a[indexA] == byte('1') && b[indexB] == byte('1') {
            digit = 0 + next
            next = 1
        } else if a[indexA] == byte('1') || b[indexB] == byte('1') {
            digit = 1 + next
            next = 0
            if digit == 2 {
                next = 1
                digit = 0
            }
        } else {
            digit = 0 + next
            next = 0
        }
        indexA--
        indexB--
        if digit == 1 {
            output = "1" + output
        } else {
            output = "0" + output
        }
    }
    for ;indexA >= 0; indexA-- {
        if a[indexA] == byte('1') {
            digit = 1 + next
        } else {
            digit = 0 + next
        }
        next = 0
        if digit == 2 {
            next = 1
            digit = 0
        }
        if digit == 1 {
            output = "1" + output
        } else {
            output = "0" + output
        }
    }
    for ;indexB >= 0; indexB-- {
        if b[indexB] == byte('1') {
            digit = 1 + next
        } else {
            digit = 0 + next
        }
        next = 0
        if digit == 2 {
            next = 1
            digit = 0
        }
        if digit == 1 {
            output = "1" + output
        } else {
            output = "0" + output
        }
    }
    if next > 0 {
        output = "1" + output
    }
    return output
}

// Runtime 0 ms Beats 100.00%
// Memory 4.42 MB Beats 58.17%
func addBinary(a string, b string) string {
    x, y := new(big.Int), new(big.Int)
    x, _ = x.SetString(a, 2)
    y, _ = y.SetString(b, 2)
    sum := new(big.Int)
    sum.Add(x, y)
    return sum.Text(2)
}