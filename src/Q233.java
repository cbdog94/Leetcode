public class Q233 {

    /**
     * 从低位开始统计每一位的1的个数
     */
    public static int countDigitOne(int n) {
        int result = 0, ratio = 1, last = 0;

        while (n > 0) {
            int remain = 0;
            if (n % 10 > 1) {
                remain = ratio;
            } else if (n % 10 == 1) {
                remain = last + 1;
            }
            result += (n / 10) * ratio + remain;
            last += n % 10 * ratio;
            ratio *= 10;
            n /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(101));
    }
}
