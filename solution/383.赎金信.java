/*
 * @lc app=leetcode.cn id=383 lang=java
 * @lcpr version=30201
 *
 * [383] 赎金信
 */

// @lc code=start

import java.util.Map;

class Solution {
    public boolean canConstruct(String s, String t) {
        /**
         * 哈希表记录一下reansomNote中出现的次数，然后再遍历一下magazine
         */
        Map<Character, Integer> map = new HashMap<>();
        // 记录一下s中各个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            } 
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

}
// @lc code=end



/*
// @lcpr case=start
// "a"\n"b"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"ab"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"aab"\n
// @lcpr case=end

 */

