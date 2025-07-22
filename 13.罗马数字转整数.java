/*
 * @lc app=leetcode.cn id=13 lang=java
 * @lcpr version=30201
 *
 * [13] 罗马数字转整数
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // 建立罗马字符到数值的映射
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if (i < s.length() - 1 && curr < map.get(s.charAt(i + 1))) {
                res -= curr;
            } else {
                res += curr;
            }

        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "III"\n
// @lcpr case=end

// @lcpr case=start
// "IV"\n
// @lcpr case=end

// @lcpr case=start
// "IX"\n
// @lcpr case=end

// @lcpr case=start
// "LVIII"\n
// @lcpr case=end

// @lcpr case=start
// "MCMXCIV"\n
// @lcpr case=end

 */

