import java.util.Arrays;
import java.util.List;

public class Q524 {

    public static String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        });
        for (String ds : d) {
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (s.charAt(i) == ds.charAt(j)) {
                    j++;
                    if (j == ds.length()) {
                        return ds;
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("c", "b", "a")));
    }

}
