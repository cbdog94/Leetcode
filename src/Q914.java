public class Q914 {

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] fre = new int[10000];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int d : deck) {
            fre[d]++;
            min = Math.min(fre[d], min);
            max = Math.max(fre[d], max);
        }
        for (int i = 2; i <= max; i++) {
            boolean flag = true;
            for (int f : fre) {
                if (f % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }
}
