public class Q242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[128];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map[sc[i]]++;
            map[tc[i]]--;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
