import java.util.ArrayList;
import java.util.List;

public class Q784 {

    public static void main(String[] args) {
        System.out.println(new Q784().letterCasePermutation("a1b2"));
        System.out.println(new Q784().letterCasePermutation("3z4"));
        System.out.println(new Q784().letterCasePermutation("12345"));
    }

    public List<String> letterCasePermutation(String S) {
        char[] sc = S.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isAlphabetic(sc[i])) {
                list.add(i);
            }
        }
        List<String> result = new ArrayList<>();
        backtrack(result, sc, 0, list);
        return result;
    }

    private void backtrack(List<String> result, char[] sc, int i, List<Integer> list) {
        if (i == list.size()) {
            result.add(new String(sc));
            return;
        }
        int index = list.get(i);
        sc[index] = Character.toLowerCase(sc[index]);
        backtrack(result, sc, i + 1, list);
        sc[index] = Character.toUpperCase(sc[index]);
        backtrack(result, sc, i + 1, list);
    }
}
