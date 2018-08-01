public class Q258 {

    public static int addDigits(int num) {
        while (num >= 10) {
            int next = 0, tmp = num;
            while (tmp > 0) {
                next += tmp % 10;
                tmp /= 10;
            }
            num = next;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(Integer.MAX_VALUE);
    }
}
