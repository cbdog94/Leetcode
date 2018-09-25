public class Q211 {

    public static void main(String[] args) {
        Q211 q = new Q211();
        WordDictionary word = q.new WordDictionary();
        word.addWord("bad");
        word.addWord("dad");
        word.addWord("mad");
        System.out.println(word.search("pad"));
        System.out.println(word.search("bad"));
        System.out.println(word.search(".ad"));
        System.out.println(word.search("b.."));
    }

    class Trie {
        int count = 0;
        Trie[] tries = new Trie[26];
    }

    class WordDictionary {

        Trie root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.tries[c - 'a'] == null) {
                    node.tries[c - 'a'] = new Trie();
                }
                node = node.tries[c - 'a'];
            }
            node.count++;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] word, int i, Trie root) {
            if (i == word.length) {
                return root.count != 0;
            }
            if (word[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (root.tries[j] != null && match(word, i + 1, root.tries[j])) {
                        return true;
                    }
                }
            } else {
                return root.tries[word[i] - 'a'] != null && match(word, i + 1, root.tries[word[i] - 'a']);
            }
            return false;
        }
    }

}
