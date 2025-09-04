/*
 * @lc app=leetcode.cn id=149 lang=java
 * @lcpr version=30202
 *
 * [149] 直线上最多的点数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int res = 1;
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        for (int i = 0; i < n - 1; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                double dx = points[j][0] - points[i][0];
                double dy = points[j][1] - points[i][1];

                double k = dx == 0 ? Double.POSITIVE_INFINITY : dy / dx;
                // 测试用例中有个k是 -0.0的，需要转成0.0
                if (k == 0) {
                    k = 0;
                }

                // 更新k的次数
                map.put(k, map.getOrDefault(k, 0) + 1);
                // 更新res
                res = Math.max(res, map.get(k));
            }
        }
        // 第一个算斜率的点没有算上，所以最后的结果 + 1
        return res + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,1],[2,2],[3,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]\n
// @lcpr case=end

 */

