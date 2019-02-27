import java.util.HashMap;
import java.util.Map;

public class Q966 {
    public static void main(String[] args) {
        System.out.println("weitu".replaceAll("aeiou", "*"));
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, Integer> precise = new HashMap<>(), ambiguous = new HashMap<>();
        for (int i = wordlist.length - 1; i >= 0; i--) {
            precise.put(wordlist[i], i);
            ambiguous.put(wordlist[i].toLowerCase(), i);
            ambiguous.put(wordlist[i].toLowerCase().replaceAll("[aeiou]", "*"), i);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i], query2, query3;
            if (precise.containsKey(query)) {
                result[i] = query;
            } else if (ambiguous.containsKey(query2 = query.toLowerCase())) {
                result[i] = wordlist[ambiguous.get(query2)];
            } else if (ambiguous.containsKey(query3 = query.toLowerCase().replaceAll("[aeiou]", "*"))) {
                result[i] = wordlist[ambiguous.get(query3)];
            } else {
                result[i] = "";
            }
        }
        return result;
    }
}
