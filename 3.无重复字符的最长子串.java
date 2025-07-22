/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30201
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 滑动窗口，从left到right，如果没有重复就 len + 1，有重复把left + 1
         *  
         */
        int left = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            // 如果没有就放进去
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            // 收缩
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }

    public int lengthOfLongestSubstring1(String s) {
        /**
         * 滑动窗口，从left到right，如果没有重复就 len + 1，有重复把left + 1
         *  
         */
        int left = 0;
        int len = 0;
        // value记录的是出现的位置，也就是下标
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            // 记录最后出现的位置
            map.put(c, right);
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

