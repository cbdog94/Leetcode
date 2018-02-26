/**
 * Created by cbdog94 on 2017/7/6.
 */
public class Q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = 0, m = 0;
        int median = 0;
        for (int i = 0; i < Math.ceil((nums1.length + nums2.length) * 1.0 / 2); i++) {
            if (m == nums2.length || n < nums1.length && nums1[n] < nums2[m]) {
                median = nums1[n];
                n++;
            } else {
                median = nums2[m];
                m++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return median;
        } else {
            if (m == nums2.length || n < nums1.length && nums1[n] < nums2[m]) {
                median += nums1[n];
            } else {
                median += nums2[m];
            }
            return median * 1.0 / 2;
        }

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{3, 4}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}));
        System.out.println(findMedianSortedArrays(new int[]{2, 3, 4, 5, 6}, new int[]{1, 2}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{1}));
    }
}
