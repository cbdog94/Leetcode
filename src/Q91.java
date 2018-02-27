public class Q91 {

    public static void main(String[] args) {
        System.out.println(numDecodings(""));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("20"));
        System.out.println(numDecodings("30"));
        System.out.println(numDecodings("2010"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("1234"));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) != '0')
                dp[0] = dp[1] = 1;
            if (i != 0) {
                int t = Integer.valueOf(s.substring(i - 1, i + 1));
                if (t == 10 || t == 20)
                    dp[i + 1] = dp[i - 1];
                else if (t > 10 && t < 26)
                    dp[i + 1] = dp[i] + dp[i - 1];
                else if (t % 10 != 0)
                    dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
