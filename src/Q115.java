import java.util.Arrays;

public class Q115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("abdcd", "abd"));
        System.out.println(numDistinct("abdcd", "ab"));
        System.out.println(numDistinct("abdcd", "d"));
        System.out.println(numDistinct("abdcd", "bb"));
        System.out.println(numDistinct("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac",
                "ceadbaa"));
    }

    //    public static int numDistinct(String s, String t) {
//        if (s.equals(t) || t.length() == 0)
//            return 1;
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == t.charAt(0))
//                result += numDistinct(s.substring(i + 1), t.substring(1));
//        }
//        return result;
//    }
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
//        dp[0][0] = 1;
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < t.length(); i++)
            for (int j = 0; j < s.length(); j++)
                if (s.charAt(j) == t.charAt(i))
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                else
                    dp[i + 1][j + 1] = dp[i + 1][j];
        return dp[t.length()][s.length()];
    }
}
