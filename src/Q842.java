import java.util.ArrayList;
import java.util.List;

public class Q842 {

    public static void main(String[] args) {
        System.out.println(new Q842().splitIntoFibonacci("1320581321313221264343965566089105744171833277577"));
        System.out.println(new Q842().splitIntoFibonacci("11235813"));
        System.out.println(new Q842().splitIntoFibonacci("112358130"));
        System.out.println(new Q842().splitIntoFibonacci("0123"));
        System.out.println(new Q842().splitIntoFibonacci("1101111"));
        System.out.println(new Q842().splitIntoFibonacci("123456579"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        backtrack("", "", S, result);
        return result;
    }

    private boolean backtrack(String num1, String num2, String s, List<Integer> result) {
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
            String add = (Integer.parseInt(num1) + Integer.parseInt(num2)) + "";
            if (s.indexOf(add) == 0) {
                result.add(Integer.parseInt(add));
                return backtrack(num2, add, s.substring(add.length()), result);
            } else {
                return false;
            }
        } else {
            for (int i = 1; i <= Math.min(s.length() / 2, 10); i++) {
                for (int j = 1; j < Math.min(s.length() - i, 11); j++) {
                    String n1 = s.substring(0, i), n2 = s.substring(i, i + j);
                    if (i == 10 && n1.compareTo(Integer.MAX_VALUE + "") > 0 || j == 10 && n2.compareTo(Integer.MAX_VALUE + "") > 0) {
                        continue;
                    }
                    result.add(Integer.parseInt(n1));
                    result.add(Integer.parseInt(n2));
                    if (backtrack(n1, n2, s.substring(i + j), result)) {
                        return true;
                    }
                    result.clear();
                }
            }
        }
        return false;
    }

}
