package Z141_160;

import java.util.Stack;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 14:25
 **/
public class MinStack155 {

    private class MinStack {

        private Stack<Integer> stack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer each : stack) {
                if (each < min) {
                    min = each;
                }
            }

            return min;
        }
    }
}
