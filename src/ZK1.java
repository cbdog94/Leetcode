import java.util.Scanner;

public class ZK1 {

    static int minW = 100;
    static int curW = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), init = 0;
        int[] c = new int[100001];
        int[] l = new int[n], d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            c[l[i]] += 1;
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            init += d[i];
        }
        desk(l, d, new int[n], l.length - 1, curW);
        System.out.println(minW);
    }

    public static void desk(int[] l, int[] w, int[] b, int k, int curW) {
        int temp[] = new int[b.length];
        System.arraycopy(b, 0, temp, 0, b.length);

        if (isBlance(l, temp)) {
            for (int i = 0; i < l.length; i++) {
                System.out.print(temp[i]);
            }
            System.out.println();
            if (minW > curW) {
                minW = curW;
            }
        }
        if (k < 0)
            return;

        desk(l, w, temp, k - 1, curW);

        temp[k] = 1;
        desk(l, w, temp, k - 1, curW + w[k]);
    }

    public static boolean isBlance(int[] l, int[] b) {
        int max = 0;
        int len = 0;
        //找到数组中最大值max
        for (int i = 0; i < l.length; i++) {
            if (l[i] > max)
                max = l[i];
            if (b[i] == 0)
                ++len;
        }
        //将没锯的桌子以长度为key统计出现次数
        int count[] = new int[max + 1];
        for (int i = 0; i < l.length; i++) {
            if (b[i] == 0) {
                count[l[i]]++;
            }
        }
        //找到长度最大桌腿，判断其次数是否大于一半
        for (int i = max; i >= 0; i--) {
            if (count[i] > 0) {
                if (count[i] > (len / 2))
                    return true;
                else
                    break;
            }
        }
        return false;
    }

}
