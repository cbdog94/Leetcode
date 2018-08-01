public class Q335 {

    public static boolean isSelfCrossing(int[] x) {

        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                System.out.println(3);
                return true;
            }

            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                    System.out.println(4);
                    return true;
                }
            }

            if (i >= 5) {
                if (x[i] + x[i - 4] >= x[i - 2] && x[i - 2] >= x[i - 4] && x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 1] <= x[i - 3]) {
                    System.out.println(5);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{3, 3, 3, 2, 1, 1}));
    }
}
