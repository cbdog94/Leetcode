import java.util.Arrays;

public class Q354 {

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int size = 0;
        int[] dp = new int[envelopes.length];
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, size, envelope[1]);
            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = envelope[1];
            if (index == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}
