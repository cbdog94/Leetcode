public class Q389 {
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray(), tc = s.toCharArray();
        int[] num = new int[26];
        for (char c : sc) {
            num[c - 'a']++;
        }
        for (char c : tc) {
            if (num[c - 'a'] == 0) {
                return c;
            }
            num[c - 'a']--;
        }
        return 0;
    }
}
