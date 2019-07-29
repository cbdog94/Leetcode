import java.util.Scanner;

public class PDD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        String[] arr1 = l1.split(" ");
        String[] arr2 = l2.split(" ");
        int[] a = new int[arr1.length];
        int[] b = new int[arr2.length];
        int cur = -1;

        for (int i = 0; i < arr1.length; i++) {
            a[i] = Integer.parseInt(arr1[i]);
            if (i == 0 || cur != -1)
                continue;
            if (a[i] <= a[i - 1])
                cur = i;
        }
        int bnode = Integer.MIN_VALUE;
        for (int i = 0; i < arr2.length; i++) {
            b[i] = Integer.parseInt(arr2[i]);
            if (b[i] > a[cur - 1] && b[i] < a[cur + 1])
                bnode = Math.max(bnode, b[i]);

        }

        if (bnode != Integer.MIN_VALUE) {
            a[cur] = bnode;
            for (int value : a) {
                System.out.print(value);
                System.out.print(" ");
            }
            return;
        }

        for (int i = 0; i < arr2.length; i++) {
            //  b[i] = Integer.parseInt(arr2[i]);
            if ((cur - 2 < 0 || b[i] > a[cur - 2]) && b[i] < a[cur])
                bnode = Math.max(bnode, b[i]);
        }

        if (bnode != Integer.MIN_VALUE) {
            a[cur - 1] = bnode;
            for (int value : a) {
                System.out.print(value);
                System.out.print(" ");
            }
            return;
        }

        System.out.print("NO");

    }

}
