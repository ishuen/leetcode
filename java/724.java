// Runtime: 5 ms, faster than 15.29% of Java online submissions for Find Pivot Index.
// Memory Usage: 40 MB, less than 97.87% of Java online submissions for Find Pivot Index.
class Solution {
  public int pivotIndex(int[] nums) {
    if (Objects.isNull(nums) || nums.length <= 2) {
      return -1;
    }
    int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
    int pivot = 0;
    int subTotal = 0;
    while (pivot < nums.length) {
      if (2 * subTotal == sum - nums[pivot]) return pivot;
      subTotal = subTotal + nums[pivot];
      pivot = pivot + 1;
    }
    return -1;
  }
}


// Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Pivot Index.
// Memory Usage: 49.7 MB, less than 6.38% of Java online submissions for Find Pivot Index.
class Solution {
  public int pivotIndex(int[] nums) {
    if (Objects.isNull(nums) || nums.length == 0) {
      return -1;
    }
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }
    int subTotal = 0;
    for (int i = 0; i < nums.length; i++) {
      if (2 * subTotal == sum - nums[i]) return i;
      subTotal = subTotal + nums[i];
    }
    return -1;
  }
}