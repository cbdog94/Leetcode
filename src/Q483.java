public class Q483 {
    public static String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        int length = (int) (Math.log(num + 1) / Math.log(2));
        for (int i = length; i >= 2; i--) {
            long l = (long) Math.pow(num, 1.0 / i);
            long r = (long) Math.pow(num, 1.0 / (i - 1));
            long mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                long cur = 0;
                for (long j = 0, k = 1; j < i; j++) {
                    cur += k;
                    k *= mid;
                }
                if (cur == num) {
                    return mid + "";
                } else if (cur < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(smallestGoodBase("2251799813685247"));
//        System.out.println(smallestGoodBase("3"));
//        System.out.println(smallestGoodBase("13"));
//        System.out.println(smallestGoodBase("4681"));
//        System.out.println(smallestGoodBase("1000000000000000000"));
    }
}
