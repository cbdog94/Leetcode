public class Q208 {

    static class Node {
        int count = 0;
        Node[] next = new Node[26];
    }

    class Trie {

        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node p = this.root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new Node();
                }
                p = p.next[index];
            }
            p.count++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node p = this.root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null) {
                    return false;
                }
                p = p.next[index];
            }
            return p.count != 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node p = this.root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null) {
                    return false;
                }
                p = p.next[index];
            }
            if (p.count != 0) {
                return true;
            }
            for (Node n : p.next) {
                if (n != null) {
                    return true;
                }
            }
            return false;
        }
    }

}
