public class Q87 {

    public static void main(String[] args) {
        System.out.println(isScramble("abcd", "abcd"));
        System.out.println(isScramble("abcd", "bdac"));
        System.out.println(isScramble("abc", "bca"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int[] list = new int[128];
        int length = s1.length();
        for (int i = 0; i < length; i++)
            list[s1.charAt(i)]++;
        for (int i = 0; i < length; i++) {
            if (list[s2.charAt(i)] == 0)
                return false;
            list[s2.charAt(i)]--;
        }
        for (int i = 1; i < length; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(length - i)) && isScramble(s1.substring(i), s2.substring(0, length - i)))
                return true;
        }
        return false;
    }
}
