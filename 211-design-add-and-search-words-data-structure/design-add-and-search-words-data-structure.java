class WordDictionary {

    // Trie Node definition
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    // Constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word into the trie
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    // Search with support for '.'
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS helper
    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }
}
