public class Q409 {

    public int longestPalindrome(String s) {
        int[] num = new int[128];
        char[] sc = s.toCharArray();
        int count = 0;
        for (char c : sc) {
            if (num[c] == 0) {
                num[c]++;
            } else {
                num[c] = 0;
                count += 2;
            }
        }
        return count == sc.length ? count : count + 1;
    }

}
