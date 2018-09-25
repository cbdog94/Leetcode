public class Q306 {


    public static void main(String[] args) {
        System.out.println(new Q306().add("1", "2"));
        System.out.println(new Q306().add("5", "6"));
        System.out.println(new Q306().add("1000", "2"));
        System.out.println(new Q306().isAdditiveNumber("112358"));
        System.out.println(new Q306().isAdditiveNumber("1123582"));
        System.out.println(new Q306().isAdditiveNumber("1123115"));
        System.out.println(new Q306().isAdditiveNumber("199100199"));
    }

    public boolean isAdditiveNumber(String num) {
        return backtrack("", "", num);
    }

    private boolean backtrack(String num1, String num2, String s) {
        if (num1.length() > 1 && num1.charAt(0) == '0') {
            return false;
        }
        if (num2.length() > 1 && num2.charAt(0) == '0') {
            return false;
        }
        if (!"".equals(num1)) {
            if ("".equals(s)) {
                return true;
            }
            String add = add(num1, num2);
            if (s.indexOf(add) == 0) {
                return backtrack(num2, add, s.substring(add.length()));
            } else {
                return false;
            }
        } else {
            for (int i = 1; i <= s.length() / 2; i++) {
                for (int j = 1; j < s.length() - i; j++) {
                    if (backtrack(s.substring(0, i), s.substring(i, i + j), s.substring(i + j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String add(String n1, String n2) {
        int l1 = n1.length(), l2 = n2.length();
        char[] result = new char[Math.max(l1, l2) + 1];
        char[] c1 = n1.toCharArray(), c2 = n2.toCharArray();
        int a, b, c = 0;
        for (int i = 0; i < result.length; i++) {
            a = b = 0;
            if (i < l1) {
                a = c1[l1 - i - 1] - '0';
            }
            if (i < l2) {
                b = c2[l2 - i - 1] - '0';
            }
            result[result.length - i - 1] = (char) ((a + b + c) % 10 + '0');
            c = (a + b + c) / 10;
        }
        return result[0] == '0' ? new String(result, 1, result.length - 1) : new String(result);
    }

}
