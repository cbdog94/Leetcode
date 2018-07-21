public class Q9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int after = 0, before = x;
        while (x != 0) {
            after = after * 10 + x % 10;
            x = x / 10;
        }
        return after == before;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1));
//        System.out.println(isPalindrome(1534236469));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }

}
