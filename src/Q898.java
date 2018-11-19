import java.util.HashSet;
import java.util.Set;

public class Q898 {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>(), lastSet = new HashSet<>();
        for (int a : A) {
            Set<Integer> set = new HashSet<>();
            set.add(a);
            for (int num : lastSet) {
                set.add(a | num);
            }
            result.addAll(lastSet);
            lastSet = set;
        }
        return result.size();
    }
}
