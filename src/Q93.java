import java.util.ArrayList;
import java.util.List;

public class Q93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> tmp = new ArrayList<>(), result = new ArrayList<>();
        restoreIpAddresses(s, 0, tmp, result);
        return result;
    }

    public static void restoreIpAddresses(String s, int left, List<String> tmp, List<String> result) {
        if (s.length() - left > (4 - tmp.size()) * 3 || s.length() - left < 4 - tmp.size()) {
            return;
        }
        if (s.length() == left) {
            result.add(tmp.get(0) + "." + tmp.get(1) + "." + tmp.get(2) + "." + tmp.get(3));
            return;
        }

        tmp.add(s.substring(left, left + 1));
        restoreIpAddresses(s, left + 1, tmp, result);
        tmp.remove(tmp.size() - 1);

        if (left + 2 <= s.length() && s.charAt(left) != '0') {
            tmp.add(s.substring(left, left + 2));
            restoreIpAddresses(s, left + 2, tmp, result);
            tmp.remove(tmp.size() - 1);
        }

        if (left + 3 <= s.length() && s.charAt(left) != '0') {
            String num3 = s.substring(left, left + 3);
            if (Integer.valueOf(num3) <= 255) {
                tmp.add(num3);
                restoreIpAddresses(s, left + 3, tmp, result);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
