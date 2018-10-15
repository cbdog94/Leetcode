public class Q738 {

    public static void main(String[] args) {
        System.out.println(new Q738().monotoneIncreasingDigits(10));
        System.out.println(new Q738().monotoneIncreasingDigits(1234));
        System.out.println(new Q738().monotoneIncreasingDigits(332));
        System.out.println(new Q738().monotoneIncreasingDigits(12341));
        System.out.println(new Q738().monotoneIncreasingDigits(123432));
    }

    public int monotoneIncreasingDigits(int N) {
        char[] c = (N + "").toCharArray();
        int i = 1;
        while (i < c.length && c[i] >= c[i - 1]) {
            i++;
        }
        for (int j = i + 1; j < c.length; j++) {
            c[j] = '9';
        }
        while (i > 0 && i < c.length && c[i] < c[i - 1]) {
            c[i] = '9';
            c[i - 1]--;
            i--;
        }
        return Integer.parseInt(new String(c));
    }

}
