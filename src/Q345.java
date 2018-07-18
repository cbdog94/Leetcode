public class Q345 {
    public static void main(String[] args) {
        System.out.println(new Q345().reverseVowels("hello"));
        System.out.println(new Q345().reverseVowels("leetcode"));
        System.out.println(new Q345().reverseVowels(""));
        System.out.println(new Q345().reverseVowels("a"));
        System.out.println(new Q345().reverseVowels("b"));
        System.out.println(new Q345().reverseVowels("bcdeeaf"));
    }

    public String reverseVowels(String s) {
        int left = -1, right = s.length();
        char[] sc = s.toCharArray();
        while (left <= right) {
            while (++left < s.length() && !isAEIOU(sc[left])) ;
            while (--right >= 0 && !isAEIOU(sc[right])) ;
            if (left <= right) {
                char tmp = sc[left];
                sc[left] = sc[right];
                sc[right] = tmp;
            }
        }
        return new String(sc);
    }

    private boolean isAEIOU(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
