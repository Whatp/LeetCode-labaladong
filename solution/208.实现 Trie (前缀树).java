/*
 * @lc app=leetcode.cn id=208 lang=java
 * @lcpr version=30201
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

import java.util.HashSet;

class Trie {

    HashSet<String> set;

    public Trie() {
        set = new HashSet<>();
    }
    
    public void insert(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        if (set.contains(word)) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for (String string : set) {
            if (string.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end



