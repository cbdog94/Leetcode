public class Q396 {

    public static int maxRotateFunction(int[] A) {
        int max = 0, base = 0;
        for (int i = 0; i < A.length; i++) {
            max += i * A[i];
            base += A[i];
        }
        int next = max;
        for (int i = A.length - 1; i > 0; i--) {
            next = next - A[i] * A.length + base;
            max = Math.max(max, next);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

}
