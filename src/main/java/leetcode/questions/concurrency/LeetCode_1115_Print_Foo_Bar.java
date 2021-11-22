package leetcode.questions.concurrency;

import java.util.concurrent.Semaphore;

// 1115. Print FooBar Alternately

public class LeetCode_1115_Print_Foo_Bar {

    public static void main(String[] args) {

    }

    class FooBar {
        private int n;
        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }
}