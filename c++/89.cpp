// 89. Gray Code
// The gray code is a binary numeral system where two successive values differ in only one bit.
//
// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
// Example 1:
//
// Input: 2
// Output: [0,1,3,2]
// Explanation:
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
//
// For a given n, a gray code sequence may not be uniquely defined.
// For example, [0,2,3,1] is also a valid gray code sequence.
//
// 00 - 0
// 10 - 2
// 11 - 3
// 01 - 1
// Example 2:
//
// Input: 0
// Output: [0]
// Explanation: We define the gray code sequence to begin with 0.
// A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
// Therefore, for n = 0 the gray code sequence is [0].

// usage of vector in c++:
// #include <vector>
// using namespace std;
// ...
// vector<int> v;

// 4 ms, faster than 69.51%
class Solution {
public:
    vector<int> grayCode(int n) {
      if (n == 1) {
        std::vector<int> arr2 {0, 1};
        return arr2;
      }
      if (n == 0) {
        std::vector<int> arr2 {0};
        return arr2;
      }
      int length = pow(2, n);
      std::vector<int> arr2(length);
      length = length/2;
      std::vector<int> arr1 = grayCode(n-1);
      for (int i = 0; i < length; i++) {
        arr2[i] = arr1[i];
        arr2[length + i] = length + arr1[length - 1 - i];
      }
      return arr2;
    }
};