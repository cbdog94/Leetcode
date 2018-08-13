import java.util.Arrays;

public class Q500 {

    public String[] findWords(String[] words) {
        byte[] map = new byte[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        String[] result = new String[words.length];
        int index = 0;
        for (String word : words) {
            char[] tmp = word.toLowerCase().toCharArray();
            int i;
            for (i = 0; i < tmp.length - 1; i++) {
                if (map[tmp[i] - 'a'] != map[tmp[i + 1] - 'a']) {
                    break;
                }
            }
            if (i == tmp.length - 1) {
                result[index++] = word;
            }
        }
        return Arrays.copyOf(result, index);
    }

}
