/*
 * @lc app=leetcode.cn id=242 lang=java
 * @lcpr version=30201
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        /**
         * 单词出现的次数相同
         */
        int[] a = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (a[c - 'a'] <= 0) {
                return false;
            } else {
                a[c - 'a']--;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "anagram"\n"nagaram"\n
// @lcpr case=end

// @lcpr case=start
// "rat"\n"car"\n
// @lcpr case=end

 */

