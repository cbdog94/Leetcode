public class Q861 {

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }

    public int matrixScore(int[][] A) {
        int r = A.length, c = A[0].length;
        int[] fre = new int[c];
        for (int i = 0; i < r; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    A[i][j] = 1 - A[i][j];
                    fre[j] += A[i][j];
                }
            } else {
                for (int j = 0; j < c; j++) {
                    fre[j] += A[i][j];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < c; i++) {
            sum += (1 << c - i - 1) * Math.max(fre[i], r - fre[i]);
        }
        return sum;
    }

}
