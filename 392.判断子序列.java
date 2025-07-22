/*
 * @lc app=leetcode.cn id=392 lang=java
 * @lcpr version=30201
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abc"\n"ahbgdc"\n
// @lcpr case=end

// @lcpr case=start
// "axc"\n"ahbgdc"\n
// @lcpr case=end

 */

