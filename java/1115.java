// 1115. Print FooBar Alternately
// Suppose you are given the following code:
//
// class FooBar {
//   public void foo() {
//     for (int i = 0; i < n; i++) {
//       print("foo");
//     }
//   }
//
//   public void bar() {
//     for (int i = 0; i < n; i++) {
//       print("bar");
//     }
//   }
// }
// The same instance of FooBar will be passed to two different threads:
//
// thread A will call foo(), while
// thread B will call bar().
// Modify the given program to output "foobar" n times.
//
//
//
// Example 1:
//
// Input: n = 1
// Output: "foobar"
// Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
// "foobar" is being output 1 time.
// Example 2:
//
// Input: n = 2
// Output: "foobarfoobar"
// Explanation: "foobar" is being output 2 times.
//
//
// Constraints:
//
// 1 <= n <= 1000
//
// Runtime 23ms Beats 89.39%of users with Java
// Memory 43.29MB Beats 5.10%of users with Java
class FooBar {
    private int n;
    Semaphore semaphoreF = new Semaphore(1);
    Semaphore semaphoreB = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semaphoreF.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            semaphoreB.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semaphoreB.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            semaphoreF.release();
        }
    }
}