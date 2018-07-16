import java.util.ArrayList;
import java.util.List;

public class Q17 {

    public static void main(String[] args) {
        System.out.println(new Q17().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        letterCombinations(digits, 0, result, "");
        return result;
    }

    public void letterCombinations(String digits, int s, List<String> result, String tmp) {
        if (digits.length() == s) {
            result.add(tmp);
            return;
        }
        switch (digits.charAt(s)) {
            case '2':
                letterCombinations(digits, s + 1, result, tmp + "a");
                letterCombinations(digits, s + 1, result, tmp + "b");
                letterCombinations(digits, s + 1, result, tmp + "c");
                break;
            case '3':
                letterCombinations(digits, s + 1, result, tmp + "d");
                letterCombinations(digits, s + 1, result, tmp + "e");
                letterCombinations(digits, s + 1, result, tmp + "f");
                break;
            case '4':
                letterCombinations(digits, s + 1, result, tmp + "g");
                letterCombinations(digits, s + 1, result, tmp + "h");
                letterCombinations(digits, s + 1, result, tmp + "i");
                break;
            case '5':
                letterCombinations(digits, s + 1, result, tmp + "j");
                letterCombinations(digits, s + 1, result, tmp + "k");
                letterCombinations(digits, s + 1, result, tmp + "l");
                break;
            case '6':
                letterCombinations(digits, s + 1, result, tmp + "m");
                letterCombinations(digits, s + 1, result, tmp + "n");
                letterCombinations(digits, s + 1, result, tmp + "o");
                break;
            case '7':
                letterCombinations(digits, s + 1, result, tmp + "p");
                letterCombinations(digits, s + 1, result, tmp + "q");
                letterCombinations(digits, s + 1, result, tmp + "r");
                letterCombinations(digits, s + 1, result, tmp + "s");
                break;
            case '8':
                letterCombinations(digits, s + 1, result, tmp + "t");
                letterCombinations(digits, s + 1, result, tmp + "u");
                letterCombinations(digits, s + 1, result, tmp + "v");
                break;
            default:
                letterCombinations(digits, s + 1, result, tmp + "w");
                letterCombinations(digits, s + 1, result, tmp + "x");
                letterCombinations(digits, s + 1, result, tmp + "y");
                letterCombinations(digits, s + 1, result, tmp + "z");
        }
    }
}
