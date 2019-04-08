public class Q1013 {
    public static void main(String[] args) {
        System.out.println(new Q1013().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(new Q1013().numPairsDivisibleBy60(new int[]{60, 60, 60}));
        System.out.println(new Q1013().numPairsDivisibleBy60(new int[]{1}));
        System.out.println(new Q1013().numPairsDivisibleBy60(new int[]{60}));
        System.out.println(new Q1013().numPairsDivisibleBy60(new int[]{0}));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int result = 0;
        for (int t : time) {
            count[t % 60]++;
        }
        for (int t : time) {
            int rest = (60 - t % 60) % 60;
            result += count[(60 - t % 60) % 60];
            if (rest == t % 60) {
                result--;
            }
        }
        return result / 2;
    }
}
