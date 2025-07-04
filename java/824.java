// 824. Goat Latin
// You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
//
// We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
//
// If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
// For example, the word "apple" becomes "applema".
// If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
// For example, the word "goat" becomes "oatgma".
// Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
// For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
// Return the final sentence representing the conversion from sentence to Goat Latin.
//
//
//
// Example 1:
//
// Input: sentence = "I speak Goat Latin"
// Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// Example 2:
//
// Input: sentence = "The quick brown fox jumped over the lazy dog"
// Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//
//
// Constraints:
//
// 1 <= sentence.length <= 150
// sentence consists of English letters and spaces.
// sentence has no leading or trailing spaces.
// All the words in sentence are separated by a single space.
//
// Runtime: 2 ms, faster than 85.28% of Java online submissions for Goat Latin.
// Memory Usage: 37.7 MB, less than 67.11% of Java online submissions for Goat Latin.
class Solution {
    public String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder suffix = new StringBuilder("ma");
        List<Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        for (int i = 1; i <= arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i - 1]);
            if (!vowels.contains(sb.charAt(0))) {
                char first = sb.charAt(0);
                sb.delete(0, 1);
                sb.append(first);
            }
            suffix.append('a');
            sb.append(suffix);
            arr[i - 1] = sb.toString();
        }
        return String.join(" ", arr);
    }
}

