import java.util.ArrayList;
import java.util.List;

public class Q71 {

    public static void main(String[] args) {
        System.out.println(new Q71().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Q71().simplifyPath("/home/"));
        System.out.println(new Q71().simplifyPath("/../"));
        System.out.println(new Q71().simplifyPath("/home//foo/"));
        System.out.println(new Q71().simplifyPath("/VO/.././../..///F/Krh"));
        System.out.println(new Q71().simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }

    public String simplifyPath(String path) {
        int last = 0, cur;
        char[] c = path.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if (c[i] == '/') {
                cur = i;
                String tmp = path.substring(last, cur);
                if ("..".equals(tmp)) {
                    if (result.size() > 0) {
                        result.remove(result.size() - 1);
                    }
                } else if (!".".equals(tmp) && !"".equals(tmp)) {
                    result.add(tmp);
                }
                last = cur + 1;
            }
        }
        if (last <= path.length()) {
            String tmp = path.substring(last, path.length());
            if ("..".equals(tmp)) {
                if (result.size() > 0) {
                    result.remove(result.size() - 1);
                }
            } else if (!".".equals(tmp) && !"".equals(tmp)) {
                result.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append("/");
            sb.append(s);
        }
        return "".equals(sb.toString()) ? "/" : sb.toString();
    }

}
