public class Q387 {

    public static int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map[c - 'a']++;
        }
        for (int i = 0; i < sc.length; i++) {
            if (map[sc[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar(""));
    }
}
