public class Q421 {

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        //Build Trie Tree
        for (int num : nums) {
            Trie cur = root;
            for (int i = 31; i >= 0; i--) {
                int t = (num >>> i) & 1;
                if (cur.child[t] == null) {
                    cur.child[t] = new Trie();
                }
                cur = cur.child[t];
            }
        }

        int max = 0;
        for (int num : nums) {
            Trie cur = root;
            int tmpMax = 0;
            for (int i = 31; i >= 0; i--) {
                int t = (num >>> i) & 1;
                if (cur.child[t ^ 1] != null) {
                    cur = cur.child[t ^ 1];
                    tmpMax |= 1 << i;
                } else {
                    cur = cur.child[t];
                }
            }
            max = Math.max(max, tmpMax);
        }
        return max;
    }

    class Trie {
        Trie[] child;

        Trie() {
            child = new Trie[2];
        }
    }
}
