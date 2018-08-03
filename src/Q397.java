public class Q397 {
    public static int integerReplacement(int n) {
        int count = 0;
        long ln = n;
        while (ln != 1) {
            if ((ln & 1) == 0) {
                ln = ln >> 1;
            } else {
                if (ln == 3 || (ln & 2) == 0) {
                    ln--;
                } else {
                    ln++;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        for (int i = 1; i <= 16; i++) {
        System.out.println(integerReplacement(2147483647));
//        System.out.println(integerReplacement(390624));
//        System.out.println(Math.pow(2,29));
//        }
    }
}
