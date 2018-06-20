public class Q6 {

    public static String convert(String s, int numRows) {
        if ("".equals(s)) {
            return "";
        }
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length() / (2 * numRows - 2) + 1; j++) {
                if ((2 * numRows - 2) * j + i < s.length()) {
                    sb.append(c[(2 * numRows - 2) * j + i]);
                }
                if (i != 0 && i != numRows - 1 && (2 * numRows - 2) * (j + 1) - i < s.length()) {
                    sb.append(c[(2 * numRows - 2) * (j + 1) - i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
