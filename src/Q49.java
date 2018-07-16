import java.util.*;

public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if (!map.containsKey(t)) {
                map.put(t, index);
                result.add(index++, new ArrayList<>());
            }
            result.get(map.get(t)).add(s);
        }
        return result;
    }
}
