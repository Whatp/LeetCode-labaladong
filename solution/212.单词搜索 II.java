/*
 * @lc app=leetcode.cn id=212 lang=java
 * @lcpr version=30202
 *
 * [212] 单词搜索 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

/**
 * 输入单词 ["cat", "car", "dog"]​​
 * ​​构建过程​​
 * ​​插入 "cat"​​：
 * c（'c'-'a'=2）→ 创建 children[2]。
 * a（'a'-'a'=0）→ 创建 children[0]。
 * t（'t'-'a'=19）→ 创建 children[19]，并标记 node.word = "cat"。
 * 
 * ​​插入 "car"​​：
 * c（已存在）→ 移动到 children[2]。
 * a（已存在）→ 移动到 children[0]。
 * r（'r'-'a'=17）→ 创建 children[17]，并标记 node.word = "car"。
 */
class Solution {
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];;
        String words;
    }

    public List<String> findWords(char[][] board, String[] words) {
        /**
         * 如果直接用DFS有的测试用例过不了，结合Trie数 + DFS，把words存入前缀树，避免重复计算
         */
        List<String> res = new ArrayList<>();
        TrieNode root = builTrieNode(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;

    }

    private TrieNode builTrieNode(String[] words) {
        // 构建一个前缀树
        TrieNode root = new TrieNode();
        for (String string : words) {
            TrieNode node = root;
            for (char c : string.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            // 这是最后一个节点才存储元素？
            node.words = string;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char temp = board[i][j];
        int index = temp - 'a';
        if (node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if (node.words != null) {
            res.add(node.words);
            // 假设 words = ["oath", "eat"]，且 board中有多个 "oath"：
            // 第一次找到 "oath" 时，将其加入 res，并置空 node.word。
            // 后续再遇到 "oath" 时，node.word == null，不会重复添加。
            node.words = null; 
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = temp;

    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n\n
 * ["oath","pea","eat","rain"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [["a","b"],["c","d"]]\n["abcb"]\n
 * // @lcpr case=end
 * 
 */
