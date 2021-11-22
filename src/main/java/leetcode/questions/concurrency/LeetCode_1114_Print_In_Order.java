package leetcode.questions.concurrency;

import java.util.concurrent.Semaphore;

//    1114. Print in Order
//    The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(),
//        and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(),
//        and third() is executed after second().
//
//        Note:
//
//        We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering.
//        The input format you see is mainly to ensure our tests' comprehensiveness.

public class LeetCode_1114_Print_In_Order {

    public static void main(String[] args) {

    }

    public static class Foo {

        Semaphore thread2 = new Semaphore(0);
        Semaphore thread3 = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            thread2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            thread2.acquire();
            printSecond.run();
            thread3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            thread3.acquire();
            printThird.run();
        }
    }
}