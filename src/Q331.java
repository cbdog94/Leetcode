import java.util.Stack;

public class Q331 {

    public static boolean isValidSerialization(String preorder) {
        if ("#".equals(preorder)) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        String[] ss = preorder.split(",");
        int i;
        for (i = 0; i < ss.length; i++) {
            if ("#".equals(ss[i])) {
//                System.out.println(i+" "+stack);
                if (stack.empty()) {
                    break;
                }
                stack.push(stack.pop() - 1);
                while (stack.peek() == 0) {
                    stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    stack.push(stack.pop() - 1);
                }
                if (stack.empty()) {
                    break;
                }
            } else {
                stack.push(2);
            }
        }
        if (!stack.empty() || i != ss.length - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
    }

}
