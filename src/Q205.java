public class Q205 {

    public static boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        char[] map = new char[128];
        boolean[] maped = new boolean[128];
        for (int i = 0; i < sc.length; i++) {
            if (map[sc[i]] == 0) {
                if (maped[tc[i]]) {
                    return false;
                } else {
                    map[sc[i]] = tc[i];
                    maped[tc[i]] = true;
                }
            } else if (map[sc[i]] != tc[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

}
