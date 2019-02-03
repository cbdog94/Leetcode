public class Q984 {
    public static void main(String[] args) {
        System.out.println(new Q984().strWithout3a3b(6, 2));
        System.out.println(new Q984().strWithout3a3b(3, 2));
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A >= 1 && B >= 1) {
            if (A > B) {
                sb.append("aab");
                A -= 2;
                B -= 1;
            } else if (B > A) {
                sb.append("bba");
                B -= 2;
                A -= 1;
            } else {
                for (int i = 0; i < A; i++) {
                    sb.append("ab");
                }
                A = 0;
                B = 0;
            }
        }
        for (int i = 0; i < A; i++) {
            sb.append("a");
        }
        for (int i = 0; i < B; i++) {
            sb.append("b");
        }
        return sb.toString();
    }
}
