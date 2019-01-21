import java.util.Arrays;

public class Q953 {
    public static void main(String[] args) {
        System.out.println(new Q953().isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(Math.pow(26, 20));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < words.length - 1; i++) {
            if (cmp(words[i], words[i + 1], map) > 0) {
                return false;
            }
        }
        return true;
    }

    private int cmp(String a, String b, int[] map) {
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            int oa = map[a.charAt(i) - 'a'], ob = map[b.charAt(i) - 'a'];
            if (oa != ob) {
                return oa - ob;
            }
        }
        if (a.length() == length) {
            if (b.length() > length) {
                return -b.charAt(length);
            }
            return 0;
        }
        return a.charAt(length);
    }
}
