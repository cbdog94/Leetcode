/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class Q5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("caba"));
        System.out.println(longestPalindrome("abacdfgdcaba"));
    }

    //直接动态规划
//    public static String longestPalindrome(String s) {
//        boolean[][] b = new boolean[s.length()][s.length()];
//        int max = 1;
//        int[] maxIndex = new int[]{0, 0};
//        for (int i = 0; i < s.length(); i++) {
//            b[i][i] = true;
//            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
//                b[i][i + 1] = true;
//                if (max < 2) {
//                    maxIndex[0] = i;
//                    maxIndex[1] = i + 1;
//                    max = 2;
//                }
//            }
//        }
//        for (int i = 3; i <= s.length(); i++)
//            for (int j = 0; j <= s.length() - i; j++) {
//                if (b[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1)) {
//                    b[j][j + i - 1] = true;
//                    if (i > max) {
//                        maxIndex[0] = j;
//                        maxIndex[1] = j + i - 1;
//                        max = i;
//                    }
//                }
//            }
//
//        return s.substring(maxIndex[0], maxIndex[1] + 1);
//    }

    //转化为Longest Common substring problem
    public static String longestPalindrome(String s) {
        String r = new StringBuffer(s).reverse().toString();
        int[][] lcs = new int[s.length() + 1][s.length() + 1];
        int max = 1;
        int[] maxIndex = new int[]{0, 1};
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= r.length(); j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    if (lcs[i][j] > max && s.length() + 1 - i == j - lcs[i - 1][j - 1]) {
                        maxIndex[0] = i - lcs[i][j];
                        maxIndex[1] = i;
                        max = lcs[i][j];
                    }
                }
            }
        return s.substring(maxIndex[0], maxIndex[1]);
    }
}
