import java.util.Scanner;

public class XiaoHong2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] sc = s.toCharArray();
        int prev = -1, last = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = sc.length - 1; i >= 0; i--) {
            if (sc[i] != ' ' && last == -1) {
                last = i;
            }
            if (sc[i] != ' ') {
                prev = i;
            }
            if (sc[i] == ' ' && prev != -1) {
                sb.append(s, prev, last + 1);
                sb.append(' ');
                prev = -1;
                last = -1;
            }
        }
        if (prev != -1) {
            sb.append(s, prev, last + 1);
        }
        System.out.println(sb.toString().trim());
    }
}
