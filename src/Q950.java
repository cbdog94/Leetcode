import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q950 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q950().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> init = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            init.add(i);
        }
        List<Integer> poll = new ArrayList<>(deck.length);
        while (!init.isEmpty()) {
            poll.add(init.pollFirst());
            if (init.isEmpty()) {
                break;
            }
            init.add(init.pollFirst());
        }
        int[] result = new int[deck.length];
        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            result[poll.get(i)] = deck[i];
        }
        return result;
    }
}
