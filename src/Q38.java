public class Q38 {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    public String countAndSay(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                count++;
            } else {
                sb.append(count);
                sb.append(c[i - 1]);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c[c.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Q38 solution=new Q38();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
    }
}
