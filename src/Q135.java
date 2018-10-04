import java.util.Arrays;

public class Q135 {

    /*public static int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int sum = 1, maxt = 1, cur = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                if (cur > 1) {
                    cur = 0;
                } else {
                    cur = cur - 1;
                }
            } else {
                if (cur < 1) {
                    sum += (1 - cur) * (1 - cur);
                    if (1 - cur >= maxt) {
                        sum += (1 - cur - maxt + 1);
                    }
                    cur = 1;
                    maxt = 1;
                }
                if (ratings[i] > ratings[i - 1]) {
                    cur++;
                    maxt = cur;
                } else {
                    cur = 1;
                    maxt = 1;
                }
            }
            sum += cur;
        }
        if (cur < 1) {
            sum += (1 - cur) * (1 - cur);
            if (1 - cur >= maxt) {
                sum += (1 - cur - maxt + 1);
            }
            cur = 1;
            maxt = 1;
        }
        return sum;
    }*/

    public static int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                num[i - 1] = Math.max(num[i] + 1, num[i - 1]);
            }
        }
        int sum = 0;
        for (int candy : num) {
            sum += candy;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{2, 2, 2, 2}));
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }
}
