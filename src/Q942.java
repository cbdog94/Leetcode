import java.util.ArrayList;
import java.util.List;

public class Q942 {

    public int[] diStringMatch(String S) {
        List<Integer> result = new ArrayList<>(S.length() + 1);
        int lastI = 0;
        result.add(0);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                lastI = i + 1;
                result.add(i + 1);
            } else {
                result.add(lastI, i + 1);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

}
