public class Q915 {
    public int partitionDisjoint(int[] A) {

        int[] min = new int[A.length], max = new int[A.length];
        max[0] = A[0];
        min[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(A[i], max[i - 1]);
            min[A.length - i - 1] = Math.min(A[A.length - i - 1], min[A.length - i]);
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}
