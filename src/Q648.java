import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q648 {
    public static void main(String[] args) {
        System.out.println(new Q648().replaceWords(Arrays.asList("catw", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String s : dict) {
            trie.add(s);
        }
        return Stream.of(sentence.split(" ")).map(trie::match).collect(Collectors.joining(" "));
    }

    class Node {
        String s;
        Node[] nodes = new Node[26];
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void add(String t) {
            Node tmp = root;
            for (char c : t.toCharArray()) {
                if (tmp.nodes[c - 'a'] == null) {
                    tmp.nodes[c - 'a'] = new Node();
                }
                tmp = tmp.nodes[c - 'a'];
            }
            tmp.s = t;
        }

        String match(String t) {
            Node tmp = root;
            for (char c : t.toCharArray()) {
                if (tmp.nodes[c - 'a'] == null) {
                    return t;
                }
                if (tmp.nodes[c - 'a'].s != null) {
                    return tmp.nodes[c - 'a'].s;
                }
                tmp = tmp.nodes[c - 'a'];
            }
            return t;
        }
    }
}
