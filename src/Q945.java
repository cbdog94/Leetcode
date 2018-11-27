public class Q945 {

    public static void main(String[] args) {
        System.out.println(new Q945().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncrementForUnique(int[] A) {
        int[] fre = new int[40001];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : A) {
            fre[a]++;
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        System.out.println(min + " " + max);
        int count = 0, sum = 0;
        for (int i = min; i <= max; i++) {
            if (fre[i] > 1) {
                count += fre[i] - 1;
                sum += (fre[i] - 1) * i;
            } else if (fre[i] == 0 && count != 0) {
                count--;
                sum -= i;
            }
        }
        for (int i = max + 1; i <= 40000 && count != 0; i++) {
            if (fre[i] == 0) {
                count--;
                sum -= i;
            }
        }
        return -sum;
    }

}
