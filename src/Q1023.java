public class Q1023 {
    public static void main(String[] args) {
        System.out.println(new Q1023().queryString("011010010011001011010101100110110", 20));
    }

    public boolean queryString(String S, int N) {
        int l = Integer.highestOneBit(N);

        if (C(S.length(), l - 1) < (1 << (l - 1))) {
            return false;
        }
        boolean[] map = new boolean[N + 1];
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length() && j - i <= 31; j++) {
//                System.out.println(Integer.valueOf(S.substring(i, j));
                int t = Integer.valueOf(S.substring(i, j), 2);
                if (t <= N) {
                    map[t] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!map[i]) {
                return false;
            }
        }
        return true;
    }

    private int C(int x, int y) {
        y = Math.min(y, x - y);
        double res = 1;
        for (int i = 0; i < y; i++) {
            res = res * (x - i) / (y - i);
        }
        return (int) res;
    }
}
