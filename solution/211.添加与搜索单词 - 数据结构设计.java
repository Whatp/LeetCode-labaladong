/*
 * @lc app=leetcode.cn id=211 lang=java
 * @lcpr version=30202
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public void insert(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
        node.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int index, TrieNode node) {
        // 递归结束
        if (index == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(index);
        // 如果是字符
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            TrieNode child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for(int i = 0; i < 26; i++) {
                TrieNode child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * ["WordDictionary","addWord","addWord","addWord","search","search","search",
 * "search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]\n
 * // @lcpr case=end
 * 
 */
