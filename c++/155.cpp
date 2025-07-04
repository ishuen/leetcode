// 155. Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.

// 20 ms, faster than 78.01%
class MinStack {
private:
  vector<int> nums;
  int min;
public:
  MinStack() {
  }

  void push(int x) {
    nums.push_back(x);
    if (nums.size() == 1 || min > x) {
      min = x;
    }
  }

  void pop() {
    if (min == nums.back()) {
      int len = nums.size();
      min = nums[0];
      for (int i = 1; i < len-1; i++) {
        if (min > nums[i]) {
          min = nums[i];
        }
      }
    }
    nums.pop_back();
  }

  int top() {
    return nums.back();
  }

  int getMin() {
    return min;
  }
};

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/