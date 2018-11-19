import java.util.Arrays;
import java.util.List;

public class Q756 {

    public static void main(String[] args) {
        System.out.println(new Q756().pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF")));
        System.out.println(new Q756().pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        return dfs(bottom, 0, allowed, new StringBuilder());
    }

    private boolean dfs(String bottom, int s, List<String> allowed, StringBuilder sb) {
        if (bottom.length() == 1) {
            return true;
        }
        if (s == bottom.length() - 1) {
            return dfs(sb.toString(), 0, allowed, new StringBuilder());
        }
        String tmp = bottom.substring(s, s + 2);
        for (String allow : allowed) {
            if (match(tmp, allow)) {
                sb.append(allow.charAt(2));
                if (dfs(bottom, s + 1, allowed, sb)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }

    private boolean match(String a, String b) {
        return a.charAt(0) == b.charAt(0) && a.charAt(1) == b.charAt(1);
    }
}
