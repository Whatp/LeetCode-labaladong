/*
 * @lc app=leetcode.cn id=28 lang=java
 * @lcpr version=30201
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }

        return -1;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "sadbutsad"\n"sad"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "leetcode"\n"leeto"\n
 * // @lcpr case=end
 * 
 */
