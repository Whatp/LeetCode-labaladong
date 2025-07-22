/*
 * @lc app=leetcode.cn id=151 lang=java
 * @lcpr version=30201
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 1. 空值检查
        if (s == null) return "";
        
        // 2. 字符验证
        if (!s.matches("^[a-zA-Z0-9 ]*$")) {
            return ""; // 或抛出IllegalArgumentException
        }
        
        // 3. 处理逻辑
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "the sky is blue"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "  hello world  "\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a good   example"\n
 * // @lcpr case=end
 * 
 */
