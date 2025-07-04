// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
//
// Example:
// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]
//
// Note:
//
// You may use one character in the keyboard more than once.
// You may assume the input string will only contain letters of alphabet.

// Runtime: 52 ms, faster than 69.76% of JavaScript online submissions for Keyboard Row.
// Memory Usage: 33.7 MB, less than 87.50% of JavaScript online submissions for Keyboard Row.

var findWords = function(words) {
  var line1 = "qwertyuiop";
  var line2 = "asdfghjkl";
  var line3 = "zxcvbnm";
  var output = [];
  words.forEach(function(word) {
    var lowercase = word.toLowerCase();
    var arr = lowercase.split('');
    var flag = true;
    if(line1.indexOf(arr[0]) != -1) {
      for (var i = 1; i< arr.length; i++) {
        if (line1.indexOf(arr[i]) == -1) {
          flag = false;
          break;
        }
      }
    } else if (line2.indexOf(arr[0]) != -1) {
      for (var i = 1; i< arr.length; i++) {
        if (line2.indexOf(arr[i]) == -1) {
          flag = false;
          break;
        }
      }
    } else if (line3.indexOf(arr[0]) != -1) {
      for (var i = 1; i< arr.length; i++) {
        if (line3.indexOf(arr[i]) == -1) {
          flag = false;
          break;
        }
      }
    } else {
      flag = false;
    }
    if(flag == true){
      output.push(word);
    }
  });
  return output;
};