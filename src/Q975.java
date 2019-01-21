public class Q975 {

    public static void main(String[] args) {
        System.out.println(new Q975().oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
//        System.out.println(new Q975().oddEvenJumps(new int[]{2,3,1,1,4}));
//        System.out.println(new Q975().oddEvenJumps(new int[]{5,1,3,4,2}));
    }

    public int oddEvenJumps(int[] A) {
        return oddEvenJumps(A, A.length - 1, new boolean[A.length]);
    }

    private int oddEvenJumps(int[] A, int e, boolean[] flag) {
        int result = 1;
        flag[e] = true;
        for (int i = 1; e - i >= 0; i += 2) {
            if (A[e - i] <= A[e]) {
                if (!flag[e - i]) {
                    result += oddEvenJumps(A, e - i, flag);
                }
                break;
            }
        }
        System.out.println(e + " " + result);
        for (int i = 2; e - i >= 0; i += 2) {
            if (A[e - i] >= A[e]) {
                if (!flag[e - i]) {
                    result += oddEvenJumps(A, e - i, flag);
                }
                break;
            }
        }
        System.out.println(e + " " + result);
        return result;
    }

}
