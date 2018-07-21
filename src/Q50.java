public class Q50 {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            //n = -n; n直接取反溢出
            x = 1 / x;
            return n % 2 == 0 ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
    }
}
