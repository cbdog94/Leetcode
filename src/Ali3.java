import java.util.*;

public class Ali3 extends Ali4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] ss = scanner.next().split(",");
            if (!map.containsKey(ss[0])) {
                map.put(ss[0], new HashSet<>());
            }
            map.get(ss[0]).add(ss[1]);
        }
        double threshold = scanner.nextDouble();
        int count = 0;
        List<String> list = new ArrayList<>(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int ci = 0, cj = 0;
                Set<String> si = map.get(list.get(i)), sj = map.get(list.get(j));
                for (String boat : si) {
                    if (sj.contains(boat)) {
                        ci++;
                    }
                }
                for (String boat : sj) {
                    if (si.contains(boat)) {
                        cj++;
                    }
                }
                if (Math.min(ci * 1.0 / sj.size(), cj * 1.0 / si.size()) > threshold) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
/*
输入：
1,1
0,0,0,2,2,2,2,0
输出：
yes,0

输入：
2,2
0,0,0,2,2,2,2,0
输出：
yes,0

输入：
3,0
0,0,0,2,2,2,2,0
输出：
no,1

输入：
3,4
0,0,0,2,2,2,2,0
输出：
no,2


 */