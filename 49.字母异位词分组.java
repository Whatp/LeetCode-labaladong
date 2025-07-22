/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30201
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if (strs.length == 0) return res;

        for (String string : strs) {
            // 拿到每个字符串的编码
            String str = help(string);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(string);
        }
        res.addAll(map.values());
        return res;
    }

    private String help(String str) {
        char[] a = new char[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            a[c - 'a']++;
        }
        return new String(a);
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["eat", "tea", "tan", "ate", "nat", "bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

