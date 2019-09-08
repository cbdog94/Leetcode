import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Unity1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(compare(s));
    }

    private static String compare(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 3; i <= 10; i++) {
            map.put(i + "", i);
        }
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("joker", 16);
        map.put("JOKER", 17);

        String[] splits = s.split("-");
        String left = splits[0], right = splits[1];
        String[] lefts = left.split(" ");
        String[] rights = right.split(" ");
        if (lefts.length == 2 && "joker".equals(lefts[0].toLowerCase()) && "joker".equals(lefts[1].toLowerCase())) {
            return left;
        }
        if (rights.length == 2 && "joker".equals(rights[0].toLowerCase()) && "joker".equals(rights[1].toLowerCase())) {
            return right;
        }
        if (lefts.length == 4 && rights.length == 4) {
            return map.get(lefts[0]) > map.get(rights[0]) ? left : right;
        }
        if (lefts.length == 4) {
            return left;
        }
        if (rights.length == 4) {
            return right;
        }
        if (lefts.length == 5 && rights.length == 5) {
            return map.get(lefts[0]) > map.get(rights[0]) ? left : right;
        }
        if (lefts.length == 3 && rights.length == 3) {
            return map.get(lefts[0]) > map.get(rights[0]) ? left : right;
        }
        if (lefts.length == 2 && rights.length == 2) {
            return map.get(lefts[0]) > map.get(rights[0]) ? left : right;
        }
        if (lefts.length == 1 && rights.length == 1) {
            return map.get(lefts[0]) > map.get(rights[0]) ? left : right;
        }
        return "ERROR";
    }
}
