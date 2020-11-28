// 804. Unique Morse Code Words

// International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//
// For convenience, the full table for the 26 letters of the English alphabet is given below:
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
// Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
//
// Return the number of different transformations among all words we have.
//
// Example:
// Input: words = ["gin", "zen", "gig", "msg"]
// Output: 2
// Explanation:
// The transformation of each word is:
// "gin" -> "--...-."
// "zen" -> "--...-."
// "gig" -> "--...--."
// "msg" -> "--...--."
//
// There are 2 different transformations, "--...-." and "--...--.".
// Note:
//
// The length of words will be at most 100.
// Each words[i] will have length in range [1, 12].
// words[i] will only consist of lowercase letters.

// Runtime: 88 ms, faster than 22.21% of JavaScript online submissions for Unique Morse Code Words.
// Memory Usage: 39.3 MB, less than 77.35% of JavaScript online submissions for Unique Morse Code Words.
var uniqueMorseRepresentations = function(words) {
    let mapping = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
    let ansObj = {};
    words.forEach(w => {
        let code = "";
        for (let i = 0; i < w.length; i++) {
            code = code + mapping[w.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)];
        }
        ansObj[code] = 1;
    })
    return Object.keys(ansObj).length;
};

// Runtime: 68 ms, faster than 99.45% of JavaScript online submissions for Unique Morse Code Words.
// Memory Usage: 39.1 MB, less than 84.14% of JavaScript online submissions for Unique Morse Code Words.
var uniqueMorseRepresentations = function(words) {
    let mapping = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
    let alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];

    let ansObj = {};
    words.forEach(w => {
        let code = "";
        for (let i = 0; i < w.length; i++) {
            code = code + mapping[alphabet.indexOf(w.charAt(i))];
        }
        ansObj[code] = 1;
    })
    return Object.keys(ansObj).length;
};

