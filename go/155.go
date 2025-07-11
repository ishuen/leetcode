// 155. Min Stack

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

 

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 

// Constraints:

// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

// Runtime 15 ms Beats 9.54%
// Memory 8.93 MB Beats 81.25%
type MinStack struct {
    stack []int
    min []int
}


func Constructor() MinStack {
    return MinStack{}
}


func (this *MinStack) Push(val int)  {
    this.stack = append(this.stack, val)
    for i := 0; i < len(this.min); i++ {
        if val <= this.min[i] {
            this.min = slices.Insert(this.min, i, val)
            break
        }
    }
    if len(this.min) == 0 || val > this.min[len(this.min) - 1] {
        this.min = append(this.min, val)
    }
    
}


func (this *MinStack) Pop()  {
    top := this.Top()
    for i := 0; i < len(this.min); i++ {
        if this.min[i] == top {
            this.min = append(this.min[:i], this.min[i + 1:]...)
        }
    }
    this.stack = this.stack[:len(this.stack) - 1]
}


func (this *MinStack) Top() int {
    return this.stack[len(this.stack) - 1]
}


func (this *MinStack) GetMin() int {
    return this.min[0]
}


// Runtime 0 ms Beats 100.00%
// Memory 9.02 MB Beats 66.89%
type MinStack struct {
    stack []int
    min int
    minIndex []int
}


func Constructor() MinStack {
    return MinStack{min: 0}
}


func (this *MinStack) Push(val int)  {
    this.stack = append(this.stack, val)
    if len(this.minIndex) == 0 {
        this.minIndex = append(this.minIndex, 0)
    } else if val <= this.min {
        this.minIndex = append(this.minIndex, len(this.minIndex))
    } else if val > this.min {
        this.minIndex = append(this.minIndex, this.minIndex[len(this.minIndex) - 1])
    }
    this.min = this.stack[this.minIndex[len(this.minIndex) - 1]]
}


func (this *MinStack) Pop()  {
    this.minIndex = this.minIndex[:len(this.minIndex) - 1]
    this.stack = this.stack[:len(this.stack) - 1]
    if (len(this.stack) > 0) {
        this.min = this.stack[this.minIndex[len(this.minIndex) - 1]]
    }
}


func (this *MinStack) Top() int {
    return this.stack[len(this.stack) - 1]
}


func (this *MinStack) GetMin() int {
    return this.min
}