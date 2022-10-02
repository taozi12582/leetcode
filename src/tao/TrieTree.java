package tao;

public class TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            //nexts[0] == null 没有走向a的路
            //nexts[0] != null 有走向a的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] words = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (char c : words) {
                index = c - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node.nexts[index].pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] words = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String word) {
            if (word == null) {
                return 0;
            }
            TrieNode node = root;
            char[] words = word.toCharArray();
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public void delete(String word) {
            if (word == null) {
                return;
            }
            if (search(word) <= 0) {
                return;
            }
            TrieNode node = root;
            node.pass--;
            int index = 0;
            char[] words = word.toCharArray();
            for (int i = 0; i < words.length; i++) {
                index = words[i] = 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

    }
}
