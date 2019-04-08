public class Q1028 {
    public static void main(String[] args) {
        System.out.println(new Q1028().baseNeg2(2));
        System.out.println(new Q1028().baseNeg2(3));
        System.out.println(new Q1028().baseNeg2(4));
    }

    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int t = (int) Math.ceil(N / (-2.0));
            sb.append(N + 2 * t);
            N = t;
        }
        return sb.reverse().toString();
    }
}
