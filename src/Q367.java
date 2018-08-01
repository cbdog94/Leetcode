public class Q367 {

    public static boolean isPerfectSquare(int num) {
        long left = 0, right = num, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i + " " + isPerfectSquare(i));
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483647 + " " + isPerfectSquare(2147483647));
    }
}
