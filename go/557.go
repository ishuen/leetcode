// 557. Reverse Words in a String III

// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "Mr Ding"
// Output: "rM gniD"
 

// Constraints:

// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.

// Runtime 5 ms Beats 37.03%
// Memory 8.45 MB Beats 65.19%
func reverseWords(s string) string {
    arr := strings.Fields(s)
    result := []string{}
    for _, str := range arr {
        var builder strings.Builder
        for i := len(str) - 1; i >= 0; i-- {
            builder.WriteByte(str[i])
        }
        result = append(result, builder.String())
    }
    return strings.Join(result, " ")
}


// Runtime 0 ms Beats 100.00%
// Memory 8.34 MB Beats 71.20%
func reverseWords(s string) string {
    arr := strings.Fields(s)
    var builder strings.Builder
    for index, str := range arr {
        for i := len(str) - 1; i >= 0; i-- {
            builder.WriteByte(str[i])
        }
        if index < len(arr) - 1 {
            builder.WriteByte(' ')
        }
    }
    return builder.String()
}