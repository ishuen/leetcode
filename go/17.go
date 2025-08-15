// 17. Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

// Runtime 0 ms Beats 100.00%
// Memory 4.07 MB Beats 56.39%
func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return []string{}
    }
    mapping := map[byte][]byte{
        '2': []byte{'a', 'b', 'c'},
        '3': []byte{'d', 'e', 'f'},
        '4': []byte{'g', 'h', 'i'},
        '5': []byte{'j', 'k', 'l'},
        '6': []byte{'m', 'n', 'o'},
        '7': []byte{'p', 'q', 'r', 's'},
        '8': []byte{'t', 'u', 'v'},
        '9': []byte{'w', 'x', 'y', 'z'},
    }
    output := []string{}
    length := len(digits)
    var sb strings.Builder
    var findComb func(index int, sb *strings.Builder)
    findComb = func(index int, sb *strings.Builder) {
        current := sb.String()
        for _, char := range mapping[digits[index]] {
            sb.WriteByte(char)
            if sb.Len() == length {
                output = append(output, sb.String())
            } else {
                findComb(index + 1, sb)
            }
            sb.Reset()
            sb.WriteString(current)
        }
    }
    findComb(0, &sb)
    return output
}