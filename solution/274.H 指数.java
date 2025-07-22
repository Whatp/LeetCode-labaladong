/*
 * @lc app=leetcode.cn id=274 lang=java
 * @lcpr version=30201
 *
 * [274] H 指数
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int hIndex(int[] citations) {
        // 至少有h篇论文被引用h次，直接去比较就可以了
        Arrays.sort(citations);
        int res = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > res)
                res++;
            else
                break;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,0,6,1,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,3,1]\n
 * // @lcpr case=end
 * 
 */
