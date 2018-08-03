public class Q372 {

    public static int superPow(int a, int[] b) {
        int result = 1, ratio = a % 1337;
        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b[i]; j++) {
                result = (result * ratio) % 1337;
            }
            int tmp = ratio;
            for (int j = 1; j < 10; j++) {
                ratio = (ratio * tmp) % 1337;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superPow(2, new int[]{1, 1, 0}));
        System.out.println(Math.pow(1024, 10) % 1337);
    }
}
