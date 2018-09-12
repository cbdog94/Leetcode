import java.util.Arrays;

public class Q902 {

    public static int atMostNGivenDigitSet(String[] D, int N) {
        int n = D.length, result = 0;
        Arrays.sort(D);
        int tN = N, tn = n, digits = 1;
        while (tN >= 10) {
            result += tn;
            tn *= n;
            tN /= 10;
            digits *= 10;
        }
        tn /= n;
//        System.out.println(result);
        while (digits > 0) {
            int index = Arrays.binarySearch(D, N / digits % 10 + "");
//            System.out.println(index);
            if (index < 0) {
                result += (-index - 1) * tn;
                break;
            } else {
                if (digits == 1) {
                    result++;
                }
                result += index * tn;
                digits /= 10;
                tn /= n;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 77));
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 5));
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));
    }

}
