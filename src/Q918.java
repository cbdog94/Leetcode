public class Q918 {
    public static void main(String[] args) {
        System.out.println(new Q918().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(new Q918().maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(new Q918().maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(new Q918().maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(new Q918().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] A) {
        int[] maxT = new int[A.length];
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
            } else {
                sum += A[i];
            }
            max = Math.max(max, sum);
            maxT[i] = sum;
        }
//        System.out.println(Arrays.toString(maxT));
        int maxt = max;
        for (int i = 0; i < A.length - 1; i++) {
            if (sum < 0) {
                sum = A[i];
            } else {
                sum += A[i];
            }
            maxt = Math.max(maxt, sum);
            max = Math.max(max, maxT[i] > 0 ? maxt - maxT[i] : maxt);
        }
        return max;
    }
}

/*
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
*/
