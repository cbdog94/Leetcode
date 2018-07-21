import java.util.ArrayList;
import java.util.List;

public class Q60 {

    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] mul = new int[n + 1];
        mul[0] = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            mul[i] = mul[i - 1] * i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(list.remove(k / mul[n - 1]));
            k %= mul[n - 1];
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(1, 1));
        System.out.println(getPermutation(2, 1));
        System.out.println(getPermutation(2, 2));
        System.out.println(getPermutation(4, 24));
        System.out.println(getPermutation(4, 9));
    }

}
