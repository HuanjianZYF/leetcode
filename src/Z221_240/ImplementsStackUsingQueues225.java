package Z221_240;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 14:01
 **/
public class ImplementsStackUsingQueues225 {

    private class MyStack {

        private Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyStack() {
            this.stack = new Stack<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the top element. */
        public int top() {
            return stack.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
