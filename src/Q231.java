public class Q231 {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (~n & (n - 1)) == n - 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(129));
    }
}
