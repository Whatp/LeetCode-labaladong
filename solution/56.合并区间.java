/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30201
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 初始判断
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int currIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = res[currIndex];
            int[] currInterval = intervals[i];
            // 结果集中的最后一个数字和当前区间的第一个数字进行比较
            if (lastInterval[1] >= currInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            } else {
                currIndex++;
                res[currIndex] = currInterval;
            }
        }

        return Arrays.copyOf(res, currIndex + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3],[2,6],[8,10],[15,18]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,4],[4,5]]\n
 * // @lcpr case=end
 * 
 */
