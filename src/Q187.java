import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q187 {

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        String tmp;
        for (int i = 0; i <= s.length() - 10; i++) {
            tmp = s.substring(i, i + 10);
            if (map.containsKey(tmp)) {
                int num = map.get(tmp);
                if (num == 1) {
                    result.add(tmp);
                }
                map.put(tmp, num + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }

}
