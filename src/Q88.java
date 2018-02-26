import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Q88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        m--;
        n--;
        while (total >= 0) {
            if (n < 0 || m >= 0 && nums1[m] > nums2[n]) {
                nums1[total--] = nums1[m--];
            } else {
                nums1[total--] = nums2[n--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 5, 6, 7, 0, 0, 0, 0, 0}, 5, new int[]{3, 4, 5}, 3);
        merge(new int[]{3, 4, 5, 0, 0, 0, 0, 0}, 3, new int[]{1, 2}, 2);
        merge(new int[]{0, 0, 0, 0, 0, 0}, 0, new int[]{1, 2}, 2);
        merge(new int[]{1, 0, 0, 0, 0, 0}, 1, new int[]{}, 0);
        merge(new int[]{0, 0, 0, 0, 0, 0}, 0, new int[]{}, 0);
    }
}
