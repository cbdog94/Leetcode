public class Q441 {

    public static int arrangeCoins(int n) {
        long t = (long) n * 2;
        long sqrt = (long) Math.sqrt(t);
        System.out.println(t);
        if (sqrt * (sqrt - 1) < t && sqrt * (sqrt + 1) > t) {
            return (int) sqrt - 1;
        } else {
            return (int) sqrt;
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
        System.out.println(arrangeCoins(1804289383));
//        }
    }
}
