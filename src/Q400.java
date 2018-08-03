public class Q400 {

    public static int findNthDigit(int n) {
        long base = 0, length = 1, ratio = 1;
        while (base + length * 9 * ratio < n) {
            base += length * 9 * ratio;
            ratio *= 10;
            length++;
        }
        long num = ratio + (n - base - 1) / length;
        for (int i = 1; i < length - (n - base - 1) % length; i++) {
            num /= 10;
        }
        return (int) (num % 10);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(findNthDigit(1000000000));
        }
//        System.out.println(findNthDigit(3));
//        System.out.println(findNthDigit(3));
//        System.out.println(findNthDigit(10));
//        System.out.println(findNthDigit(11));
//        System.out.println(findNthDigit(12));
    }

}
