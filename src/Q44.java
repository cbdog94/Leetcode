public class Q44 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));// false
        System.out.println(isMatch("aa", "aa"));//  true
        System.out.println(isMatch("aaa", "aa"));//  false
        System.out.println(isMatch("aa", "*"));//  true
        System.out.println(isMatch("aa", "a*"));//  true
        System.out.println(isMatch("ab", "?*"));//  true
        System.out.println(isMatch("aab", "c*a*b"));//  false
//        System.out.println(isMatch("aab", "c*a*ba"));//  true
        System.out.println(isMatch("aaa", "a*a"));//  true
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++)
            dp[0][j + 1] = p.charAt(j) == '*' && dp[0][j];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++)
                if (p.charAt(j) != '*')
                    dp[i + 1][j + 1] = (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && dp[i][j];
                else
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
        return dp[s.length()][p.length()];
    }
}
