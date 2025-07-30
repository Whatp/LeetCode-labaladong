/*
 * @lc app=leetcode.cn id=57 lang=java
 * @lcpr version=30202
 *
 * [57] 插入区间
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // newInterval先加入进去，再排序，再合并
        int[][] temp = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, temp, 0, intervals.length);
        temp[intervals.length] = newInterval;
        Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));

        // 后面和合并区间一致
        int[][] res = new int[temp.length][2];
        // 先初始
        res[0] = temp[0];
        // 结果集中的最后索引
        int lastIndex = 0;
        for (int i = 1; i < temp.length; i++) {
            // 结果集中的最后区间
            int[] lastInterval = res[lastIndex];
            // 当前遍历到的区间
            int[] currInterval = temp[i];
            if (currInterval[0] <= lastInterval[1]) {
                // 有重叠的情况
                lastInterval[1] = Math.max(currInterval[1], lastInterval[1]);
            } else {
                lastIndex++;
                res[lastIndex] = temp[i];
            }
        }
        
        return Arrays.copyOf(res, lastIndex + 1);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3],[6,9]]\n[2,5]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[3,5],[6,7],[8,10],[12,16]]\n[4,8]\n
// @lcpr case=end

 */

