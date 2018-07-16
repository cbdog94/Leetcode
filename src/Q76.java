public class Q76 {

    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] sc = s.toCharArray();
        int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE, counter = 0;
        while (end < s.length()) {
            if (map[sc[end++]]-- > 0) {
                counter++;
            }
            while (counter == t.length()) {
                if (end - begin < len) {
                    len = end - (head = begin);
                }
                if (map[sc[begin++]]++ == 0) {
                    counter--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("ABC", "ABC"));
        System.out.println(minWindow("aa", "ABC"));
        System.out.println(minWindow("ABFCGHHCBAhh", "ABC"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(minWindow("aaabdabcefaecbef", "abc"));
        System.out.println(minWindow("baAaABabBba", "AbbB"));
    }

}
