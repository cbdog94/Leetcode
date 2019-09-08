import java.util.Scanner;

public class Tencent1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(decompress(s));
    }

    private static String decompress(String s) {
        char[] sc = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0, start = -1, i;
        int num = 0;
        for (i = 0; Character.isDigit(sc[i]); i++) {
            num = num * 10 + sc[i] - '0';
        }
        if (num == 0) {
            num = 1;
        } else {
            i++;
        }
        for (; i < sc.length; i++) {
            if (Character.isAlphabetic(sc[i]) && count == 0) {
                sb.append(sc[i]);
            } else if (sc[i] == '[') {
                if (count == 0) {
                    start = i;
                }
                count++;
            } else if (sc[i] == ']') {
                count--;
                if (count == 0) {
                    sb.append(decompress(s.substring(start + 1, i)));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < num; j++) {
            res.append(sb.toString());
        }
        return res.toString();
    }


}
