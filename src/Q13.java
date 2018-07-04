public class Q13 {

    public static void main(String[] args) {
        System.out.println(new Q13().romanToInt("III"));
        System.out.println(new Q13().romanToInt("IV"));
        System.out.println(new Q13().romanToInt("IX"));
        System.out.println(new Q13().romanToInt("LVIII"));
        System.out.println(new Q13().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int last = 0, cur, total = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            switch (c[i]) {
                case 'I':
                    cur = 1;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'D':
                    cur = 500;
                    break;
                default:
                    cur = 1000;
                    break;
            }
            if (cur >= last) {
                total += cur;
            } else {
                total -= cur;
            }
            last = cur;
        }
        return total;
    }
}
