import java.util.Arrays;

public class Q321 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{5, 1, 0}, new int[]{5, 2, 1}, 3)));
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15)));
        System.out.println(Arrays.toString(new Q321().maxNumber(new int[]{3, 3, 3, 2, 3, 7, 3, 8, 6, 0, 5, 0, 7, 8, 9, 2, 9, 6, 6, 9, 9, 7, 9, 7, 6, 1, 7, 2, 7, 5, 5, 1}, new int[]{5, 6, 4, 9, 6, 9, 2, 2, 7, 5, 4, 3, 0, 0, 1, 7, 1, 8, 1, 5, 2, 5, 7, 0, 4, 3, 8, 7, 3, 8, 5, 3, 8, 3, 4, 0, 2, 3, 8, 2, 7, 1, 2, 3, 8, 7, 6, 7, 1, 1, 3, 9, 0, 5, 2, 8, 2, 8, 7, 5, 0, 8, 0, 7, 2, 8, 5, 6, 5, 9, 5, 1, 5, 2, 6, 2, 4, 9, 9, 7, 6, 5, 7, 9, 2, 8, 8, 3, 5, 9, 5, 1, 8, 8, 4, 6, 6, 3, 8, 4, 6, 6, 1, 3, 4, 1, 6, 7, 0, 8, 0, 3, 3, 1, 8, 2, 2, 4, 5, 7, 3, 7, 7, 4, 3, 7, 3, 0, 7, 3, 0, 9, 7, 6, 0, 3, 0, 3, 1, 5, 1, 4, 5, 2, 7, 6, 2, 4, 2, 9, 5, 5, 9, 8, 4, 2, 3, 6, 1, 9}, 160)));
        System.out.println(Arrays.toString(new Q321().maxNumber(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                200)));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = null;
        int[][] dp1 = dp(nums1, k);
        int[][] dp2 = dp(nums2, k);
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(k, nums1.length); i++) {
            int[] tmp = merge(dp1[i], i, dp2[k - i], k - i);
            if (greater(tmp, 0, k, res, 0, k))
                res = tmp;
        }
        return res;
    }

    /**
     * if res1 is greater than res2
     */
    private boolean greater(int[] res1, int s1, int l1, int[] res2, int s2, int l2) {
        if (res2 == null || s2 >= l2)
            return true;
        if (res1 == null || s1 >= l1)
            return false;
        int i, j;
        for (i = s1, j = s2; i < l1 && j < l2; i++, j++) {
            if (res1[i] > res2[j])
                return true;
            else if (res1[i] < res2[j])
                return false;
        }
        return j == l2;
    }

    private int[] merge(int[] dp1, int l1, int[] dp2, int l2) {
        if (l1 == 0)
            return dp2;
        if (l2 == 0)
            return dp1;
        int[] res = new int[l1 + l2];
        for (int i = 0, j = 0, r = 0; r < res.length; r++)
            if (greater(dp1, i, l1, dp2, j, l2))
                res[r] = dp1[i++];
            else
                res[r] = dp2[j++];
        return res;
    }

    private int[][] dp(int[] nums, int k) {
        int length = Math.min(nums.length, k);
        int[][] res = new int[length + 1][length];
        int[] init = new int[nums.length];
        int remove = nums.length - k;
        int top = -1;
        for (int i : nums) {
            while (remove > 0 && top >= 0 && i > init[top]) {
                init[top--] = i;
                --remove;
            }
            init[++top] = i;

        }
        res[length] = Arrays.copyOfRange(init, 0, length);
        for (int i = length; i > 1; i--) {
            int j;
            for (j = 0; j < length - 1; j++) {
                if (res[i][j] < res[i][j + 1]) {
                    break;
                }
                res[i - 1][j] = res[i][j];
            }
            for (; j < length - 1; j++) {
                res[i - 1][j] = res[i][j + 1];
            }
        }
        return res;
    }

}
