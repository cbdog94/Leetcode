public class Q318 {

    public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int t = 0;
            for (char c : words[i].toCharArray()) {
                t |= (1 << c - 'a');
            }
            map[i] = t;
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((map[i] & map[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

}
