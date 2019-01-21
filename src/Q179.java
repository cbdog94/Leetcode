import java.util.Arrays;

public class Q179 {
    public static void main(String[] args) {
        System.out.println(new Q179().largestNumber(new int[]{10, 2}));
        System.out.println(new Q179().largestNumber(new int[]{3332, 33, 34, 5, 9}));
        System.out.println(new Q179().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Q179().largestNumber(new int[]{0, 0}));
        System.out.println(new Q179().largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
        System.out.println(new Q179().largestNumber(new int[]{121, 12}));
        System.out.println(new Q179().largestNumber(new int[]{830, 8308}));
    }

    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = nums[i] + "";
        }
        Arrays.sort(ss, (x, y) -> {
            int length = Math.min(x.length(), y.length());
            for (int i = 0; i < length; i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    return y.charAt(i) - x.charAt(i);
                }
            }
            if (x.length() > length) {
                for (int i = length; i < x.length(); i++) {
                    if (x.charAt(i) != y.charAt(0)) {
                        return y.charAt(0) - x.charAt(i);
                    }
                }
                return y.charAt(length - 1) - x.charAt(x.length() - 1);
            }
            if (y.length() > length) {
                for (int i = length; i < y.length(); i++) {
                    if (y.charAt(i) != x.charAt(0)) {
                        return y.charAt(i) - x.charAt(0);
                    }
                }
                return y.charAt(y.length() - 1) - x.charAt(length - 1);
            }
            return 0;
        });
        if (ss[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
}
