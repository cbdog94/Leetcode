
import java.util.ArrayList;
import java.util.List;

public class Q212 {

    public static void main(String[] args) {
        System.out.println(new Q212().findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, Trie root, List<String> result) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        Trie next = root.next[c - 'a'];
        if (next.s != null) {
            result.add(next.s);
            next.s = null;
            //return; 不能return，需要继续查找
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, next, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, next, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, next, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, next, result);
        }
        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                }
                p = p.next[c - 'a'];
            }
            p.s = word;
        }
        return root;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String s;
    }
}
