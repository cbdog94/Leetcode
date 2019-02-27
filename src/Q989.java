import java.util.LinkedList;
import java.util.List;

public class Q989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int c = 0, t;
        List<Integer> result = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            t = A[i] + K % 10 + c;
            result.add(0, t % 10);
            c = t / 10;
            K /= 10;
        }
        while (K != 0 || c != 0) {
            t = K % 10 + c;
            result.add(0, t % 10);
            c = t / 10;
            K /= 10;
        }
        return result;
    }
}
