// 229. Majority Element II
//
//   Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//   Follow-up: Could you solve the problem in linear time and in O(1) space?
//
//
//
//   Example 1:
//
//   Input: nums = [3,2,3]
//   Output: [3]
//   Example 2:
//
//   Input: nums = [1]
//   Output: [1]
//   Example 3:
//
//   Input: nums = [1,2]
//   Output: [1,2]
//
//
//   Constraints:
//
//   1 <= nums.length <= 5 * 104
//   -109 <= nums[i] <= 109
//
// Runtime: 9 ms, faster than 22.01% of Java online submissions for Majority Element II.
// Memory Usage: 41.9 MB, less than 91.45% of Java online submissions for Majority Element II.

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int limit = Math.round(nums.length / 3);
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return map.keySet().stream().filter(key -> map.get(key) > limit).collect(Collectors.toList());
  }
}


// Runtime: 7 ms, faster than 37.52% of Java online submissions for Majority Element II.
// Memory Usage: 41.9 MB, less than 91.45% of Java online submissions for Majority Element II.

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int limit = Math.round(nums.length / 3);
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer> ansList = new ArrayList<>();
    for (int key : map.keySet()) {
      if (map.get(key) > limit) {
        ansList.add(key);
      }
    }
    return ansList;
  }
}

// Runtime: 1 ms, faster than 99.89% of Java online submissions for Majority Element II.
// Memory Usage: 43 MB, less than 51.03% of Java online submissions for Majority Element II.
class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int limit = Math.round(nums.length / 3);
    int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
    for (int num: nums) {
      if (count1 == 0 && num != candidate2) {
        candidate1 = num;
        count1 = 1;
      } else if (count2 == 0 && num != candidate1) {
        candidate2 = num;
        count2 = 1;
      } else if (num == candidate1) {
        count1++;
      } else if (num == candidate2) {
        count2++;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int num: nums) {
      if (num == candidate1) {
        count1++;
      } else if (num == candidate2) {
        count2++;
      }
    }
    List<Integer> ans = new ArrayList<>();
    if (count1 > limit) {
      ans.add(candidate1);
    }
    if (count2 > limit) {
      ans.add(candidate2);
    }
    return ans;
  }
}
