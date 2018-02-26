/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Q152 {
    public int maxProduct(int[] A) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < A.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);
            System.out.println(imax + "\n" + imin + "\n-------");
            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println(new Q152().maxProduct(new int[]{2,3,-2,4}));
        System.out.println(new Q152().maxProduct(new int[]{3, 4, -2, 2, 8}));
//        System.out.println(new Q152().maxProduct(new int[]{2,3,-2,4,-1,5,7,-10}));
//        System.out.println(new Q152().maxProduct(new int[]{1,2,3,4}));
//        System.out.println(new Q152().maxProduct(new int[]{-1,-2,-3}));
//        System.out.println(new Q152().maxProduct(new int[]{-1}));
    }
}
