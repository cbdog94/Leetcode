import java.util.ArrayList;
import java.util.List;

public class Q282 {


    public static void main(String[] args) {
        System.out.println(new Q282().addOperators("123", 6));
        System.out.println(new Q282().addOperators("232", 8));
        System.out.println(new Q282().addOperators("105", 5));
        System.out.println(new Q282().addOperators("00", 0));
        System.out.println(new Q282().addOperators("000", 0));
        System.out.println(new Q282().addOperators("3456237490", 9191));
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperators(result, num, "", target, 0, 0, 0);
        return result;
    }

    private void addOperators(List<String> result, String num, String tmp, int target, int pos, long lastSum, long lastValue) {
        if (pos == num.length() && lastSum == target) {
            result.add(tmp);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long val = Long.valueOf(num.substring(pos, i + 1));
            if (pos == 0) {
                addOperators(result, num, Long.toString(val), target, i + 1, val, val);
            } else {
                addOperators(result, num, tmp + "+" + val, target, i + 1, lastSum + val, val);
                addOperators(result, num, tmp + "-" + val, target, i + 1, lastSum - val, -val);
                addOperators(result, num, tmp + "*" + val, target, i + 1, lastSum - lastValue + lastValue * val, lastValue * val);
            }
        }
    }
}
