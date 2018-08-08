import java.util.HashMap;
import java.util.Map;

public class Q290 {

    public static boolean wordPattern(String pattern, String str) {
        String[] splits = str.split(" ");
        if (pattern.length() != splits.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
//        Set<String> maped = new HashSet<>();
        char[] pc = pattern.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            if (!map.containsKey(pc[i])) {
                if (map.containsValue(splits[i])) {
                    return false;
                } else {
                    map.put(pc[i], splits[i]);
                }
            } else if (!map.get(pc[i]).equals(splits[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

}
