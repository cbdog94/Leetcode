public class Q65 {

    public static boolean isNumber(String s) {
        s = s.trim();
        char[] sc = s.toCharArray();
        boolean point = false, e = false, num1 = false, num2 = false;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '-') {
                if (!(i == 0 || sc[i - 1] == 'e' || sc[i - 1] == 'E')) {
                    return false;
                }
            } else if (sc[i] == '.') {
                if (!point && !e) {
                    point = true;
                } else {
                    return false;
                }
            } else if (sc[i] == 'e' || sc[i] == 'E') {
                if (num1 && !e) {
                    e = true;
                } else {
                    return false;
                }
            } else if (Character.isDigit(sc[i])) {
                if (!num1) {
                    num1 = true;
                }
                if (e && !num2) {
                    num2 = true;
                }
            } else {
                return false;
            }
        }
        if (e && !num2) {
            return false;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("2e"));
        System.out.println(isNumber("2E1"));
        System.out.println(isNumber("2.1E-1"));
        System.out.println(isNumber("2.1E0.1"));
        System.out.println(isNumber(".3"));
    }

}
