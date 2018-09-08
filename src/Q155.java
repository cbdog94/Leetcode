import java.util.Stack;

public class Q155 {

    public static void main(String[] args) {

    }

    class MinStack {

        Stack<Long> stack;
        long min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }


        public void push(int x) {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }

        public void pop() {
            long pop = stack.pop();
            if (pop < 0) {
                min -= pop;
            }
        }

        public int top() {
            long top = stack.peek();
            if (top < 0) {
                return (int) min;
            }
            return (int) (min + top);
        }

        public int getMin() {
            return (int) min;
        }
    }
}
