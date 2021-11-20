package leet.code.questions.concurrency;

import java.util.concurrent.Semaphore;

public class LeetCode_1114 {

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