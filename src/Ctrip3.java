import java.util.Scanner;

public class Ctrip3 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    private static int schedule(int m, int[] array) {
        int start = 1, end = 0;

        for (int value : array) {
            end += value;
        }
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, array, m)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    private static boolean check(int mid, int[] array, int m) {
        int count = 0;
        int sum = 0;
        for (int value : array) {
            if (value > mid) {
                return false;
            }
            sum += value;
            if (sum > mid) {
                count++;
                sum = value;
            }
        }
        count++;
        return count <= m;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(res);
    }
}
