/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30201
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 统计一下t中各个字符出现的次数
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 左右边界和有效字符的个数
        int left = 0, right = 0, valid = 0;
        int minLen = Integer.MAX_VALUE;
        // 记录起始位置
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (count.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只有字符对应的数量也相等，才++
                if (count.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 尝试缩小窗口，这里是count.size()而不是t.length()
            while (valid == count.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // 移除
                char d = s.charAt(left);
                left++;

                if (count.containsKey(d)) {
                    // 这一步是关键，必须恰好相等的时候移出去，才会导致状态的变化
                    if (window.get(d).equals(count.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "ADOBECODEBANC"\n"ABC"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"aa"\n
 * // @lcpr case=end
 * 
 */
