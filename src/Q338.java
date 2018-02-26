import java.util.Arrays;

public class Q338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            dp[i] = Integer.bitCount(i);
        }
        return dp;
    }

//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        ans[0] = 0;
//        for (int i = 1; i <= num; i++) {
//            if ((i & 1) == 1) ans[i] = ans[i >> 1] + 1;
//            else ans[i] = ans[i >> 1];
//        }
//
//        return ans;
//    }
}
