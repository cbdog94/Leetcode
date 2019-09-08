import java.util.Arrays;
import java.util.Scanner;

public class Tencent5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n = 1 << n;
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int q = scanner.nextInt();
            q = 1 << q;
//            System.out.println("&&"+q+"&&");
            for (int j = 0; j < n / q; j++) {
//                System.out.println(q/2);
                for (int k = 0; k < q / 2; k++) {
                    int t = arrays[k + j * q];
                    arrays[k + j * q] = arrays[q - k - 1 + j * q];
                    arrays[q - k - 1 + j * q] = t;
                }
            }
//            System.out.println(Arrays.toString(arrays));

            int[] tt = Arrays.copyOf(arrays, n);

            if (i == 0) {
                System.out.println(reversePairs(tt));
            } else {
                System.out.println(reversePairs(tt));
            }
        }

    }

    private static int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private static int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }

}
