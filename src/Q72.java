public class Q72 {

    public static void main(String[] args) {
        System.out.println(minDistance("abagc", "addsghb"));
//        System.out.println(minDistance("addsghb","abagc"));

    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= word2.length(); i++)
            dp[0][i] = i;
        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++)
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
        for (int[] row : dp) {
            for (int item : row)
                System.out.print(item + " ");
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }
}
