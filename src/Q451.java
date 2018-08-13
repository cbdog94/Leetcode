public class Q451 {

//    class Pair {
//        int key;
//        int val;
//
//        Pair(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new Q451().frequencySort("tree"));
        System.out.println(new Q451().frequencySort("cccaaa"));
        System.out.println(new Q451().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        char[] sc = s.toCharArray(), result = new char[s.length()];
        int[] fre = new int[128];
        for (char c : sc) {
            fre[c]++;
        }
        int index = 0;
        while (index < result.length) {
            int max = 0;
            for (int i = 0; i < 128; i++) {
                if (fre[i] > fre[max]) {
                    max = i;
                }
            }
            for (int i = 0; i < fre[max]; i++) {
                result[index++] = (char) max;
            }
            fre[max] = 0;
        }
        return new String(result);
    }

}
