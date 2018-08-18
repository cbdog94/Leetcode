import java.util.Stack;

public class Q394 {

    public static String decodeString(String s) {
        char[] sc = s.toCharArray();
        Stack<String> sStack = new Stack<>();
        Stack<Integer> nStack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        nStack.push(1);
        sStack.push("");
        for (int i = 0; i < sc.length; i++) {
            System.out.println(i);
            if (Character.isDigit(sc[i])) {
                if (i != 0 && !Character.isDigit(sc[i - 1])) {
                    sStack.push(sb.toString());
                    sb = new StringBuilder();
                }
                num = num * 10 + (sc[i] - '0');
            } else if (sc[i] == '[') {
                nStack.push(num);
                num = 0;
            } else if (sc[i] == ']') {
                StringBuilder pre = new StringBuilder(sStack.pop());
                String cur = sb.toString();
                System.out.println(nStack);
                int count = nStack.pop();
                for (int j = 0; j < count; j++) {
                    pre.append(cur);
                }

//                sStack.push( pre.toString());
                System.out.println(sStack);
                sb = new StringBuilder(pre.toString());
            } else {
                sb.append(sc[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
