public class Q978 {

    public static void main(String[] args) {
        System.out.println(new Q978().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(new Q978().maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(new Q978().maxTurbulenceSize(new int[]{100}));
    }

    public int maxTurbulenceSize(int[] A) {
        int result = 1, tmp = 1, flag = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (flag != 1) {
                    flag = 1;
                    tmp++;
                } else {
                    result = Math.max(result, tmp);
                    tmp = 2;
                }
            } else if (A[i] < A[i - 1]) {
                if (flag != -1) {
                    flag = -1;
                    tmp++;
                } else {
                    result = Math.max(result, tmp);
                    tmp = 2;
                }
            } else {
                flag = 0;
                result = Math.max(result, tmp);
                tmp = 1;
            }
        }
        return result;
    }

}
