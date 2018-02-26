public class Q670 {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(1993));
    }

    public static int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            char max = c[i];
            int maxIndex = i;
            for (int j = i + 1; j < c.length; j++) {
                if (c[j] > max || maxIndex != i && c[j] == max) {
                    max = c[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                char t = c[i];
                c[i] = c[maxIndex];
                c[maxIndex] = t;
                return Integer.parseInt(String.copyValueOf(c));
            }
        }
        return num;
    }
}
