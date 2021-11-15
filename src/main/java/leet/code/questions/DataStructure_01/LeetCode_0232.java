package leet.code.questions.DataStructure_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//        232. Implement Queue using Stacks
//        Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
//        functions of a normal queue (push, peek, pop, and empty).
//
//        Implement the MyQueue class:
//
//        void push(int x) Pushes element x to the back of the queue.
//        int pop() Removes the element from the front of the queue and returns it.
//        int peek() Returns the element at the front of the queue.
//        boolean empty() Returns true if the queue is empty, false otherwise.
//        Notes:
//
//        You must use only standard operations of a stack, which means only push to top, peek/pop from top, size,
//        and is empty operations are valid.
//        Depending on your language, the stack may not be supported natively. You may simulate a stack using a
//        list or deque (double-ended queue) as long as you use only a stack's standard operations.

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class LeetCode_0232 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

    static class MyQueue {

        private final LinkedList<Integer> stack = new LinkedList<>();
        private final LinkedList<Integer> queue = new LinkedList<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (queue.isEmpty()) {
                while (!stack.isEmpty()) {
                    queue.push(stack.pop());
                }
            }
            return queue.pop();
        }

        public int peek() {
            if (!queue.isEmpty()) {
                return queue.peek();
            } else {
                while (!stack.isEmpty()) {
                    queue.push(stack.pop());
                }
            }
            return queue.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && queue.isEmpty();
        }
    }

    static class MyQueue1 {

        private final LinkedList<Integer> stack = new LinkedList<>();
        private final LinkedList<Integer> temp = new LinkedList<>();

        public MyQueue1() {

        }

        public void push(int x) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(x);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}