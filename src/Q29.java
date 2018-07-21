public class Q29 {
    static int ok = 0;

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = dividend < 0 ^ divisor < 0;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long result = 0;
        while (ldividend >= ldivisor) {
            long tmp = ldivisor, q = 1;
            while (ldividend >= (tmp << 1)) {
                ok++;
                tmp <<= 1;
                q <<= 1;
            }
            ldividend -= tmp;
            result += q;
//            int tmp = 0;
//            while ((ldivisor << (tmp+1)) <= ldividend) {
//                ok++;
//                tmp++;
//            }
//            ldividend -= (ldivisor << tmp);
//            result += (1L<<tmp);
        }
        return sign ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
        System.out.println(divide(-2147483648, 2));
        System.out.println(ok);
    }

}
