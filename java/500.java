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


// Runtime: 3 ms, faster than 12.50% of Java online submissions for Keyboard Row.
// Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Keyboard Row.

class Solution {
  public String[] findWords(String[] words) {
    List<String> ans = new ArrayList<>();
    int hashTable[] = new int[26];
    char chars[][] = {{'q','w','e','r','t','y','u','i','o','p'},
                      {'a','s','d','f','g','h','j','k','l'},
                      {'z','x','c','v','b','n','m'}};
    for (int i = 0; i < chars.length; i++){
      for (int j = 0; j < chars[i].length; j++){
        hashTable[chars[i][j] - 'a'] = i + 1;
      }
    }

    boolean isInSameRow = true;
    for (int i = 0; i < words.length; i++){
      int row = hashTable[Character.toLowerCase(words[i].charAt(0)) - 'a'];
      for (int j = words[i].length() - 1; j > 0 ; j-- ){
        if (hashTable[Character.toLowerCase(words[i].charAt(j)) - 'a'] != row){
          isInSameRow = false;
          break;  
        }    
      }
      if (isInSameRow){
        ans.add(words[i]);
      } else {
        isInSameRow = true;
      }
    }
    return ans.stream().toArray(String[] ::new);
  }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Keyboard Row.
// Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Keyboard Row.

class Solution {
  public String[] findWords(String[] words) {
    String ans[] = new String[words.length];
    int index = 0;

    int hashTable[] = new int[26];
    char chars[][] = {{'q','w','e','r','t','y','u','i','o','p'},
                      {'a','s','d','f','g','h','j','k','l'},
                      {'z','x','c','v','b','n','m'}};
    for(int i = 0; i < chars.length; i++){
      for(int j = 0; j < chars[i].length; j++){
        hashTable[chars[i][j] - 'a'] = i + 1;
      }
    }

    boolean isInSameRow = true;
    for (int i = 0; i < words.length; i++){
      int row = hashTable[Character.toLowerCase(words[i].charAt(0)) - 'a'];
      for (int j = words[i].length() - 1; j > 0 ; j-- ){
        if (hashTable[Character.toLowerCase(words[i].charAt(j)) - 'a'] != row){
          isInSameRow = false;
          break;  
        }    
      }
      if (isInSameRow){
        ans[index] = words[i];
        index++;
      } else {
        isInSameRow = true;
      }
    }
    String [] result = new String[index];
    for(int i = 0; i < index; i++){
      result[i] = ans[i];
    }
    return result;
  }
}

// conclusion: array is faster than array list