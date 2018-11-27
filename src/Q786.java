import java.util.Arrays;

public class Q786 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 1)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 2)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 4)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 5)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 6)));
        System.out.println(Arrays.toString(new Q786().kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    /*
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Arrays.sort(A);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble(x -> A[x[0]] * 1.0 / A[x[1]]));
        for (int i = 0; i < A.length - 1; i++) {
            queue.offer(new int[]{i, A.length - 1});
        }
        while (K > 1) {
            int[] t = queue.poll();
            if (t[1] - 1 != t[0]) {
                queue.offer(new int[]{t[0], t[1] - 1});
            }
            K--;
        }
        return new int[]{A[queue.peek()[0]], A[queue.peek()[1]]};
    }*/

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Arrays.sort(A);
        double left = A[0] * 1.0 / A[A.length - 1], right = 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            int result = 0;
            int p = 0, q = 1;
            for (int i = 0, j = 1; i < A.length - 1; i++) {
                while (j < A.length && A[i] * 1.0 / A[j] > mid) {
                    j++;
                }
                result += A.length - j;
                if (j < A.length && p * A[j] < q * A[i]) {
                    p = A[i];
                    q = A[j];
                }
            }
            if (result > K) {
                right = mid;
            } else if (result < K) {
                left = mid;
            } else {
                return new int[]{p, q};
            }
        }
        return new int[]{A[0], A[A.length - 1]};
    }
}