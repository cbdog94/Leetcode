public class Q415 {

    public static String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int a, b, c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(c1.length, c2.length); i++) {
            if (i < c1.length) {
                a = c1[c1.length - 1 - i] - '0';
            } else {
                a = 0;
            }
            if (i < c2.length) {
                b = c2[c2.length - 1 - i] - '0';
            } else {
                b = 0;
            }
            sb.append((a + b + c) % 10);
            c = (a + b + c) / 10;
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9", "1"));
        System.out.println(addStrings("999", "12"));
        System.out.println(addStrings("111", "222"));
    }
}
