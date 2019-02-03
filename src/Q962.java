import java.util.Stack;

public class Q962 {
    /*public int maxWidthRamp(int[] A) {
        int result = 0;
        for (int j = A.length - 1; j > 0; j--) {
            if (j != A.length - 1 && A[j] <= A[j + 1]) {
                continue;
            }
            for (int i = 0; i < j - result; i++) {
                if (A[i] <= A[j]) {
                    result = Math.max(result, j - i);
                    break;
                }
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        System.out.println(new Q962().maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(new Q962().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
        System.out.println(new Q962().maxWidthRamp(new int[]{1}));
        System.out.println(new Q962().maxWidthRamp(new int[]{3, 2, 1}));
    }

    public int maxWidthRamp(int[] A) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.empty() || A[i] < A[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (stack.empty()) {
                return result;
            }
            while (!stack.empty() && A[i] >= A[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }
        return result;
    }
}
