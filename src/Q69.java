public class Q69 {

    public static int mySqrt(int x) {
        for (long i = 0; i <= x; i++) {
            if (i * i > x) {
                return (int) i - 1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }
}
