import java.util.Arrays;
import java.util.Scanner;

public class EA1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            int one = scanner.nextInt(), two = scanner.nextInt();
            nums[i][0] = Math.min(one, two);
            nums[i][1] = Math.max(one, two);
        }
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = nums[i][1];
        }
        System.out.println(findNumberOfLIS(nums2));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, maxLen = 0, mod = 1_000_000_007;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] = (cnt[i] + cnt[j]) % mod;
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (maxLen == len[i]) {
                res = (res + cnt[i]) % mod;
            }
            if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}