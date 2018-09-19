import java.util.Stack;

public class Q907 {

    public static int sumSubarrayMins(int[] A) {
        int mod = 1_000_000_007;
        Stack<int[]> stack1 = new Stack<>(), stack2 = new Stack<>();
        int[] left = new int[A.length], right = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack1.empty() && stack1.peek()[0] > A[i]) {
                count += stack1.pop()[1];
            }
            stack1.push(new int[]{A[i], count});
            left[i] = count;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack2.empty() && stack2.peek()[0] >= A[i]) {
                count += stack2.pop()[1];
            }
            stack2.push(new int[]{A[i], count});
            right[i] = count;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = (result + A[i] * left[i] * right[i]) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[]{81, 55, 2}));
    }
}
