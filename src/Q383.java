public class Q383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        int length = ransomNote.length();
        if (length == 0) {
            return true;
        }
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (map[c - 'a']-- > 0) {
                length--;
            }
            if (length == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("", "effjfggbffjdgbjjhhdegh"));
        System.out.println(canConstruct("fffbfg", ""));
        System.out.println(canConstruct("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
    }
}
