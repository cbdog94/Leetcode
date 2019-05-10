public class Q1006 {
    public int clumsy(int N) {
        if (N <= 2) {
            return N;
        }
        int i;
        int sum = 0;
        sum += N * (N - 1) / (N - 2);
        for (i = N - 3; i >= 4; i -= 4) {
            sum += i - (i - 1) * (i - 2) / (i - 3);
        }
        return i > 0 ? sum + 1 : sum;
    }
}
