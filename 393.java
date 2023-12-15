// 393. UTF-8 Validation
//
// Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).
//
// A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//
// For a 1-byte character, the first bit is a 0, followed by its Unicode code.
// For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.
// This is how the UTF-8 encoding would work:
//
//      Number of Bytes   |        UTF-8 Octet Sequence
//                        |              (binary)
//    --------------------+-----------------------------------------
//             1          |   0xxxxxxx
//             2          |   110xxxxx 10xxxxxx
//             3          |   1110xxxx 10xxxxxx 10xxxxxx
//             4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// x denotes a bit in the binary form of a byte that may be either 0 or 1.
//
// Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
//
//
//
// Example 1:
//
// Input: data = [197,130,1]
// Output: true
// Explanation: data represents the octet sequence: 11000101 10000010 00000001.
// It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
// Example 2:
//
// Input: data = [235,140,4]
// Output: false
// Explanation: data represented the octet sequence: 11101011 10001100 00000100.
// The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
// The next byte is a continuation byte which starts with 10 and that's correct.
// But the second continuation byte does not start with 10, so it is invalid.
//
//
// Constraints:
//
// 1 <= data.length <= 2 * 104
// 0 <= data[i] <= 255
//
// Runtime 10 ms Beats 23.04% of users with Java
// Memory 43.88 MB Beats 57.59% of users with Java
class Solution {
    public boolean validUtf8(int[] data) {
        int nBytes = 0;
        for(int number: data) {
            String binary = Integer.toBinaryString(number);
            if (binary.length() < 8) {
                StringBuilder sb = new StringBuilder(binary);
                for (int i = 0; i < 8 - binary.length(); i++) {
                    sb.insert(0, "0");
                }
                binary = sb.toString();
            } else if (binary.length() > 8) {
                return false;
            }
            if (nBytes > 0) {
                if (!binary.startsWith("10")) {
                    return false;
                } else {
                    nBytes--;
                }
            } else {
                if (binary.startsWith("110")) {
                    nBytes = 1;
                } else if (binary.startsWith("1110")) {
                    nBytes = 2;
                } else if (binary.startsWith("11110")) {
                    nBytes = 3;
                } else if (!binary.startsWith("0")) {
                    return false;
                }
            }
        }
        return nBytes == 0;
    }
}

// Runtime 1 ms Beats 98.43% of users with Java
// Memory 44.96 MB Beats 8.90% of users with Java
class Solution {
    public boolean validUtf8(int[] data) {
        int nBytes = 0;
        for(int number: data) {   
            if (nBytes > 0) {
                if ((number >> 6) != 0b10) {
                    return false;
                } else {
                    nBytes--;
                }
            } else {
                if ((number >> 5) == 0b110) {
                    nBytes = 1;
                } else if ((number >> 4) == 0b1110) {
                    nBytes = 2;
                } else if ((number >> 3) == 0b11110) {
                    nBytes = 3;
                } else if ((number >> 7) != 0) {
                    return false;
                }
            }
        }
        return nBytes == 0;
    }
}
