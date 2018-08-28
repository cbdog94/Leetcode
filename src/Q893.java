import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String a : A) {
            char[] ac = a.toCharArray();
            char[] even = new char[(ac.length + 1) / 2];
            char[] odd = new char[ac.length / 2];
            int ei = 0, oi = 0;
            for (int i = 0; i < ac.length; i++) {
                if (i % 2 == 0) {
                    even[ei++] = ac[i];
                } else {
                    odd[oi++] = ac[i];
                }
            }
            Arrays.sort(even);
            Arrays.sort(odd);
            set.add(new String(even) + new String(odd));
        }
        return set.size();
    }
}
