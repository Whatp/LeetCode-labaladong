/*
 * @lc app=leetcode.cn id=290 lang=java
 * @lcpr version=30201
 *
 * [290] 单词规律
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        /**
         * 单词和字符串之间存在一种映射
         */
        String[] words = s.split("\\s+");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> patToS = new HashMap<>();
        Map<String, Character> sToPat = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // 检查字符到单词的映射
            if (patToS.containsKey(c)) {
                // 映射不相等
                if (!word.equals(patToS.get(c))) {
                    return false;
                }
            } else { // 不在映射中，就加进去
                patToS.put(c, word);
            }

            // 检查单词→字符的映射
            if (sToPat.containsKey(word)) {
                if (sToPat.get(word) != c) {
                    return false;
                }
            } else {
                sToPat.put(word, c);
            }
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abba"\n"dog cat cat dog"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abba"\n"dog cat cat fish"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aaaa"\n"dog cat cat dog"\n
 * // @lcpr case=end
 * 
 */
