public class Q58 {
    public static int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        boolean flag = false;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != ' ') {
                count++;
                flag = true;
            } else if (flag)
                break;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
