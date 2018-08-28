public class Q668 {

    public static int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(m, mid / i);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(3, 3, 1));
        System.out.println(findKthNumber(3, 3, 2));
        System.out.println(findKthNumber(3, 3, 3));
        System.out.println(findKthNumber(3, 3, 4));
        System.out.println(findKthNumber(3, 3, 5));
        System.out.println(findKthNumber(3, 3, 6));
        System.out.println(findKthNumber(3, 3, 7));
        System.out.println(findKthNumber(3, 3, 8));
        System.out.println(findKthNumber(3, 3, 9));
        System.out.println(findKthNumber(2, 3, 6));
    }
}
