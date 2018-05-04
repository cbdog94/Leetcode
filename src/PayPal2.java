import java.util.Scanner;

//
//public class PayPal2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(f(n));
//    }
//
//    public static String f(int n) {
//        if (n == 1)
//            return "3";
//        if (n <= 3)
//            return "6";
//        BigInteger[] dp = new BigInteger[n + 1];
//        dp[2] = BigInteger.valueOf(6);
//        dp[3] = BigInteger.valueOf(6);
//        for (int i = 4; i <= n; i++) {
//            dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2)).add(dp[i - 1]);
//        }
//        return dp[n].toString();
//    }
//}
public class PayPal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] ss = s.split(":");
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(Long.parseLong(ss[0] + ss[1], 16));
        } catch (Exception e) {
            sb.append("-1");
        }
        sb.append(" ");
        try {
            sb.append(Integer.parseInt(ss[2] + ss[3], 16));
        } catch (Exception e) {
            sb.append("-1");
        }
        sb.append(" ");
        try {
            sb.append(Integer.parseInt(ss[4] + ss[5], 16));
        } catch (Exception e) {
            sb.append("-1");
        }
        sb.append(" ");
        try {
            sb.append(Long.parseLong(ss[6] + ss[7], 16));
        } catch (Exception e) {
            sb.append("-1");
        }
        System.out.println(sb.toString());
    }
    //0:001:000:02:0000:A:FFFF:FFFF


}

