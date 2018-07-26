public class Q204 {

    public static int countPrimes(int n) {
        boolean[] flag = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    flag[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
