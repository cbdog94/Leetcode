public class Q402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("00192345", 3));
        System.out.println(removeKdigits("1234567890", 9));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() <= k)
            return "0";
        char[] stack = new char[num.length()];
        int top = -1;
        for (char cur : num.toCharArray()) {
            while (k > 0 && top >= 0 && cur < stack[top]) {
                top--;
                k--;
            }
            stack[++top] = cur;
        }
        int i;
        for (i = 0; i <= top; i++)
            if (stack[i] != '0')
                break;
        return i + k == top + 1 ? "0" : new String(stack, i, top + 1 - i - k);
    }

    //144ms
//    public static String removeKdigits(String num, int k) {
//        if (num.length() <= k)
//            return "0";
//        for (int i = 0; i < k; i++) {
//            int j;
//            for (j = 0; j < num.length() - 1; j++)
//                if (num.charAt(j) > num.charAt(j + 1))
//                    break;
//            num = num.substring(0, j) + num.substring(j + 1, num.length());
//        }
//        for (int i = 0; i < num.length(); i++)
//            if (num.charAt(i) != '0')
//                return num.substring(i);
//        return "0";
//    }


}
