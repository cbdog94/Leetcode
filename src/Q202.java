import java.util.HashSet;
import java.util.Set;

public class Q202 {

    public static void main(String[] args) {
        System.out.println(new Q202().isHappy(18));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            if (n == 1) {
                return true;
            }
            set.add(n);
            n = square(n);
        }
        return false;
    }

    private int square(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}
