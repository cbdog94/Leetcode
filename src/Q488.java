import java.util.ArrayList;
import java.util.List;

public class Q488 {

//    int min=6;

    public static void main(String[] args) {
        System.out.println(new Q488().findMinStep("WRRBBW", "RB"));
        System.out.println(new Q488().findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(new Q488().findMinStep("G", "GGGGG"));
        System.out.println(new Q488().findMinStep("RBYYBBRRB", "YRBGB"));
    }

    public int findMinStep(String board, String hand) {
        int result = findMinStep(board, hand, 1);
        return result == 6 ? -1 : result;
    }

    private int findMinStep(String board, String hand, int count) {
        int min = 6;
        for (int i = 0; i < hand.length(); i++) {
            if (board.indexOf(hand.charAt(i)) != -1) {
                List<String> tmpResult = next(board, hand.charAt(i));
                String nextHand = hand.substring(0, i) + hand.substring(i + 1);
                for (String tmp : tmpResult) {
                    if ("".equals(tmp)) {
                        return count;
                    }
                    min = Math.min(min, findMinStep(tmp, nextHand, count + 1));
                }
            }
        }
        return min;
    }

    private List<String> next(String board, char cur) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length(); i++) {
            if ((i == 0 || board.charAt(i - 1) != cur) && board.charAt(i) == cur) {
                String s = board.substring(0, i) + cur + board.substring(i);
                result.add(process(s, i));
            }
        }
        return result;
    }

    private String process(String board, int index) {
        if ("".equals(board)) {
            return board;
        }
        int left = index, right = index;
        while (left >= 0 && board.charAt(left) == board.charAt(index)) {
            left--;
        }
        while (right < board.length() && board.charAt(right) == board.charAt(index)) {
            right++;
        }
        if (right - left - 1 < 3) {
            return board;
        }
        String processed = board.substring(0, left + 1) + board.substring(right);
        return process(processed, left == -1 ? 0 : left);
    }
}
