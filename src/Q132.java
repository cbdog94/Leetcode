import java.util.Arrays;

public class Q132 {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("abaa"));
        System.out.println(minCut("aabaa"));
        System.out.println(minCut("abcdef"));
        System.out.println(minCut("abcdee"));
        System.out.println(minCut("ccaacabacb"));
        System.out.println(minCut("ccaaca"));
    }

    public static int minCut(String s) {
        int length = s.length();
        int[][] dp = new int[length + 1][length + 1];
        for (int n = 2; n <= length; n++) {
            for (int i = 0; i <= length - n; i++) {

                if (s.charAt(i) == s.charAt(i + n - 1) && dp[i + 2][i + n - 1] == 0) {
                    dp[i + 1][i + n] = 0;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                //0 3 0 1 1 3 0 2 0 3
                for (int j = i + 1; j < i + n; j++) {
                    min = Math.min(min, dp[i + 1][j] + dp[j + 1][i + n] + 1);
                }
                dp[i + 1][i + n] = min;
            }
        }
//        for(int[] r:dp){
//            System.out.println(Arrays.toString(r));
//        }
        return dp[1][s.length()];
    }
}
