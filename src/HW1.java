import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(process(s));
    }

    private static String process(String s) {
        String[] splits = s.split("@");
        if (splits.length == 1) {
            return splits[0];
        }
        String all = splits[0], have = splits[1];
        int[] count = new int[128];
        List<Character> list = new ArrayList<>();
        for (String pair : all.split(",")) {
            String[] ss = pair.split(":");
            list.add(ss[0].charAt(0));
            count[ss[0].charAt(0)] = Integer.parseInt(ss[1]);
        }
        for (String pair : have.split(",")) {
            String[] ss = pair.split(":");
            count[ss[0].charAt(0)] -= Integer.parseInt(ss[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            if (count[c] != 0) {
                if (sb.length() != 0) {
                    sb.append(',');
                }
                sb.append(c);
                sb.append(':');
                sb.append(count[c]);
            }
        }
        return sb.toString();
    }
}
