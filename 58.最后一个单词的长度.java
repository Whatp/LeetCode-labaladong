/*
 * @lc app=leetcode.cn id=58 lang=java
 * @lcpr version=30201
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        /**
         * 先找到最后一个不为空的字符，再往前找为空的地方
         */
        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') end--;
        int start = end;
        while (start >=0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "Hello World"\n
// @lcpr case=end

// @lcpr case=start
// "   fly me   to   the moon  "\n
// @lcpr case=end

// @lcpr case=start
// "luffy is still joyboy"\n
// @lcpr case=end

 */

