public class Q567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char[] s1c = s1.toCharArray(), s2c = s2.toCharArray();
        int[] fre = new int[26];
        for (char c1 : s1c) {
            fre[c1 - 'a']++;
        }
        int[] cur = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cur[s2c[i] - 'a']++;
        }
        if (equal(fre, cur)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            cur[s2c[i] - 'a']++;
            cur[s2c[i - s1.length()] - 'a']--;
            if (equal(fre, cur)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(int[] fre, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (fre[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }
}
