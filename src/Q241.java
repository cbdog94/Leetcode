import java.util.ArrayList;
import java.util.List;

public class Q241 {
    public static void main(String[] args) {
        System.out.println(new Q241().diffWaysToCompute("2-1-1"));
        System.out.println(new Q241().diffWaysToCompute("2*3-4*5"));
        System.out.println(new Q241().diffWaysToCompute("2"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        char[] ic = input.toCharArray();
        for (int i = 0; i < ic.length; i++) {
            if (!Character.isDigit(ic[i])) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (ic[i]) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                        }

                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
