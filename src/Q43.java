public class Q43 {
    public static void main(String[] args) {
        System.out.println(new Q43().multiply("9", "99"));
        System.out.println(new Q43().multiply("1000", "1"));
        System.out.println(new Q43().multiply("9", "999"));
        System.out.println(new Q43().multiply("2", "3"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l2 - 1; i >= 0; i--) {
            for (int j = l1 - 1; j >= 0; j--) {
                int t = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                result[i + j + 1] += t;
            }
        }
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i > 0; i--) {
            sb.append((result[i] + c) % 10);
            c = (result[i] + c) / 10;
        }
        if (c > 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
