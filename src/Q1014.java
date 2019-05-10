public class Q1014 {
    public static void main(String[] args) {
        System.out.println(new Q1014().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new Q1014().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new Q1014().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
//        System.out.println(new Q1014().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int result = 0;
        int sum = 0;
        for (int w : weights) {
            result = Math.max(result, w);
            sum += w;
        }
        result = Math.max(result, (int) Math.ceil(sum * 1.0 / D));
        for (int i = result; i <= 500; i++) {
            if (check(weights, D, i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean check(int[] weights, int D, int pack) {
        int sum = 0, d = 0;
        for (int w : weights) {
            sum += w;
            if (sum > pack) {
                d++;
                sum = w;
            }
            if (d >= D) {
                return false;
            }
        }
        return true;
    }

}
