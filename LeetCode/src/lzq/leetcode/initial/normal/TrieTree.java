package lzq.leetcode.initial.normal;

public class TrieTree {
    static class Trie {
        boolean isEnd = false;
        Trie[] sons = new Trie[26];

        public Trie() {

        }

        public void insert(String word) {
            if (null == word || word.length() <= 0) {
                return;
            }
            char w = word.charAt(0);
            Trie slot = sons[w - 'a'];
            if (null == slot) {
                Trie son = new Trie();
                sons[w - 'a'] = son;
            }
            if (word.length() == 1) {
                sons[w - 'a'].isEnd = true;
            } else {
                sons[w - 'a'].insert(word.substring(1));
            }
        }

        public boolean search(String word) {
            if (word.length() == 0) {
                return isEnd;
            }
            return sons[word.charAt(0) - 'a'] != null && sons[word.charAt(0) - 'a'].search(word.substring(1));
        }

        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }
            return sons[prefix.charAt(0) - 'a'] != null && sons[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.startsWith("app"));
    }
}
