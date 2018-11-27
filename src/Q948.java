import java.util.Arrays;

public class Q948 {
    public static void main(String[] args) {
        System.out.println(new Q948().bagOfTokensScore(new int[]{26}, 51));
        System.out.println(new Q948().bagOfTokensScore(new int[]{100}, 50));
        System.out.println(new Q948().bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(new Q948().bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        int count = 0, max = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            while (left < tokens.length && P >= tokens[left]) {
                P -= tokens[left];
                count++;
                left++;
            }
            max = Math.max(max, count);
            if (count > 0) {
                count--;
                P += tokens[right];
                right--;
            } else {
                break;
            }
        }
        return max;
    }
}
