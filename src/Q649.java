import java.util.LinkedList;
import java.util.Queue;

public class Q649 {

    public static void main(String[] args) {
        System.out.println(new Q649().predictPartyVictory("RRDD"));
        System.out.println(new Q649().predictPartyVictory("RDD"));
        System.out.println(new Q649().predictPartyVictory("RD"));
        System.out.println(new Q649().predictPartyVictory("DDRRR"));
        System.out.println(new Q649().predictPartyVictory("DDRRRR"));
        System.out.println(new Q649().predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }

    public String predictPartyVictory(String senate) {
        char[] sc = senate.toCharArray();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll(), di = d.poll();
            if (ri < di) {
                r.offer(ri + sc.length);
            } else {
                d.offer(di + sc.length);
            }
        }
        return r.size() > d.size() ? "Radiant" : "Dire";
    }
}
