import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MS1 {

    public static void main(String[] args) {
        System.out.println(new MS1().distinctPasswords(2, new String[]{"abcda", "cdaba"}));
    }

    public int distinctPasswords(int input1, String[] input2) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < input1; i++) {
            String s = input2[i];
            int n = s.length();
            char[] chars = s.toCharArray();
            char[] ji_char = new char[n / 2];//ji
            char[] ou_char = new char[n - n / 2];//ou
            for (int j = 1; j < n; j += 2)
                ji_char[j / 2] = chars[j];
            for (int j = 0; j < n; j += 2)
                ou_char[j / 2] = chars[j];
            Arrays.sort(ji_char);
            String left = new String(ji_char);
            Arrays.sort(ou_char);
            String right = new String(ou_char);
            String temp = left + ";" + right;
            if (!set.contains(temp)) {
                set.add(temp);
                count += 1;
            }
        }
        return count;
    }
}