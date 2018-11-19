import java.util.Scanner;


public class SAP1 {

    public static void main(String[] args) {
        int max = 0;
        int[] fre = new int[3001];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            fre[t]++;
            max = Math.max(fre[t], max);
        }
        for (int i = 1; i <= 3000; i++) {
            if (fre[i] == max) {
                System.out.println(i + " " + max);
            }
        }
    }

}
