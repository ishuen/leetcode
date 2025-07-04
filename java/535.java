// 535. Encode and Decode TinyURL
// Note: This is a companion problem to the System Design problem: Design TinyURL.
// TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
//
// There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
//
// Implement the Solution class:
//
// Solution() Initializes the object of the system.
// String encode(String longUrl) Returns a tiny URL for the given longUrl.
// String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
//
//
// Example 1:
//
// Input: url = "https://leetcode.com/problems/design-tinyurl"
// Output: "https://leetcode.com/problems/design-tinyurl"
//
// Explanation:
// Solution obj = new Solution();
// string tiny = obj.encode(url); // returns the encoded tiny url.
// string ans = obj.decode(tiny); // returns the original url after deconding it.
//
//
// Constraints:
//
// 1 <= url.length <= 104
// url is guranteed to be a valid URL.
//
// Runtime: 9 ms, faster than 19.55% of Java online submissions for Encode and Decode TinyURL.
// Memory Usage: 38.9 MB, less than 87.94% of Java online submissions for Encode and Decode TinyURL.
public class Codec {

    private String baseUrl = "https://tiny.url/";
    private int increment;
    private Map<Integer, String> map;
    
    public Codec() {
        increment = 0;
        map = new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(increment, longUrl);
        return baseUrl + increment++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int inc = Integer.parseInt(shortUrl.replace(baseUrl, ""));
        return map.get(inc);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));