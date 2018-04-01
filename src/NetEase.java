import java.util.Arrays;
import java.util.Scanner;

public class NetEase {

    public static void main(String[] args) {
//        System.out.println((long)(Math.pow(2,30)));
        long a=0;
        for(int i=0;i<30;i++)
            a+=1000000000;
        System.out.println(a);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long total = sc.nextLong();
        long[] v = new long[num];
        for (int i = 0; i < num; i++)
            v[i] = sc.nextLong();
        Arrays.sort(v);
        System.out.println(f(v, num, total));
    }

    public static long f(long[] v, int l, long total) {
        long sum = 0;
        for (int i = 0; i < l; i++) {
            sum += v[i];
        }
        if (sum <= total)
            return (long) Math.pow(2, l);
        if (v[l - 1] > total)
            return f(v, l - 1, total);
        return f(v, l - 1, total - v[l - 1]) + f(v, l - 1, total);
    }
}
