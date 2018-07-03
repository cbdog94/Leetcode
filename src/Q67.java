public class Q67 {

    public static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        boolean c = false;
        for (int i = 0; i < maxLen; i++) {
            char A = '0', B = '0';
            if (i < a.length()) {
                A = a.charAt(i);
            }
            if (i < b.length()) {
                B = b.charAt(i);
            }
            if (A == '0' && B == '0') {
                if (c) {
                    c = false;
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            } else if (A == '1' && B == '1') {
                sb.append(c ? '1' : '0');
                c = true;
            } else {
                if (c) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
        }
        if (c) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
