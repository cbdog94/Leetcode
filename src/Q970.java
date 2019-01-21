import java.util.*;

public class Q970 {

    public static void main(String[] args) {
        System.out.println(new Q970().powerfulIntegers(2, 3, 10));
        System.out.println(new Q970().powerfulIntegers(3, 5, 15));
        System.out.println(new Q970().powerfulIntegers(1, 2, 100));
        System.out.println(new Q970().powerfulIntegers(2, 1, 100));
        System.out.println(new Q970().powerfulIntegers(2, 1, 0));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int left = 1;
        Set<Integer> set = new HashSet<>();
        while (left < bound) {
            int tmp = 1;
            while (left + tmp <= bound) {
                set.add(left + tmp);
                if (y == 1) {
                    break;
                }
                tmp *= y;
            }
            if (x == 1) {
                break;
            }
            left *= x;
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

}
