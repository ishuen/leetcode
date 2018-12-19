// 187. Repeated DNA Sequences
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
// Example:
//
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
// Output: ["AAAAACCCCC", "CCCCCAAAAA"]

class Solution {
public:
  // Time Limit Exceeded
  // vector<string> findRepeatedDnaSequences(string s) {
  //   int length = s.size();
  //   if (length <= 10) return vector<string>();
  //   vector<bool> count;
  //   vector<string> sub;
  //   vector<string> result;
  //   bool found = false;
  //   int len = 0;
  //   for (int i = 0; i < length - 9; i++) {
  //     string temp = s.substr(i, 10);
  //     for (int j = 0; j < len; j++) {
  //       if (sub[j] == temp) {
  //         found = true;
  //         if (count[j] == false) {
  //           count[j] = true;
  //           result.push_back(temp);
  //         }
  //         break;
  //       }
  //     }
  //     if (found == false) {
  //       sub.push_back(temp);
  //       count.push_back(false);
  //       len++;
  //     } else {
  //       found = false;
  //     }
  //   }
  //   return result;
  // }
  // 36 ms, faster than 61.37%
  vector<string> findRepeatedDnaSequences(string s) {
    vector<string> result;
    unordered_map<string, bool> visited;
    unordered_map<string, bool> used;
    int len = s.size();
    for (int i = 0; i < len - 9; i++) {
      string ss = s.substr(i, 10);
      if (visited[ss] == true && used[ss] == false) {
        result.push_back(ss);
        used[ss] = true;
      }
      else {
        visited[ss] = true;
      }
    }
    return result;
  }
};