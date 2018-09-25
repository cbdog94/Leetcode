public class Q526 {

    int count = 0;

    public int countArrangement(int N) {
        backtrack(N, 1, new boolean[N + 1]);
        return count;
    }

    private void backtrack(int N, int cur, boolean used[]) {
        if (cur == N + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i] && (i % cur == 0 || cur % i == 0)) {
                used[i] = true;
                backtrack(N, cur + 1, used);
                used[i] = false;
            }
        }
    }
}
