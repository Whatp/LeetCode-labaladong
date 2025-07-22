/*
 * @lc app=leetcode.cn id=205 lang=java
 * @lcpr version=30201
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a = new char[256];
        char[] b = new char[256];
        
        for (int i = 0; i < s.length(); i++) {
            char s_ = s.charAt(i);
            char t_ = t.charAt(i);

            if (a[s_] == 0) {
                a[s_] = t_;
            } else if (a[s_] != t_) {
                return false;
            }

            if (b[t_] == 0) {
                b[t_] = s_;
            } else if (b[t_] != s_) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "egg"\n"add"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "foo"\n"bar"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "paper"\n"title"\n
 * // @lcpr case=end
 * 
 */
