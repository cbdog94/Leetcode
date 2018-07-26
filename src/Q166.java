import java.util.HashMap;
import java.util.Map;

public class Q166 {

    public static String fractionToDecimal(int numerator, int denominator) {
        boolean sign = (numerator < 0 ^ denominator < 0) && numerator != 0;
        long lNumerator = Math.abs((long) numerator);
        long lDenominator = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        if (sign) {
            sb.append('-');
        }
        Map<String, Integer> map = new HashMap<>();
        long q = lNumerator / lDenominator;
        sb.append(q);
        lNumerator -= q * lDenominator;
        if (0 != lNumerator) {
            sb.append('.');
        } else {
            return sb.toString();
        }
        int index = sb.length();
        while (0 != lNumerator) {
            if (lNumerator < lDenominator) {
                lNumerator *= 10;
            }
            q = lNumerator / lDenominator;
            lNumerator -= q * lDenominator;
            if (lNumerator != 0) {
                if (!map.containsKey(q + " " + lNumerator)) {
                    map.put(q + " " + lNumerator, index++);
                } else {
                    break;
                }
            }
            sb.append(q);
        }
        if (lNumerator != 0) {
            sb.insert((int) map.get(q + " " + lNumerator), '(');
            sb.append(')');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.format("%.20f\n", 1.0 / 51);
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(1, 4));
        System.out.println(fractionToDecimal(1, 5));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(1, 7));
        System.out.println(fractionToDecimal(1, 8));
        System.out.println(fractionToDecimal(1, 9));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(7, 6));
        System.out.println(fractionToDecimal(0, -7));
        System.out.println(fractionToDecimal(-1, 51));
    }
}
