/*
 * @lc app=leetcode.cn id=6 lang=java
 * @lcpr version=30201
 *
 * [6] Z 字形变换
 */

// @lc code=start

import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows < 2) return s;
        int i = 0, flag = -1;
        List<StringBuilder> rows = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            rows.add(new StringBuilder());
        }
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : rows) {
            res.append(stringBuilder);
        }

        return res.toString();

    }
}
// @lc code=end



/*
// @lcpr case=start
// "PAYPALISHIRING"\n3\n
// @lcpr case=end

// @lcpr case=start
// "PAYPALISHIRING"\n4\n
// @lcpr case=end

// @lcpr case=start
// "A"\n1\n
// @lcpr case=end

 */

