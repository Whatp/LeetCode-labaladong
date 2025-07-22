/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30201
 *
 * [169] 多数元素
 */

// @lc code=start

import java.util.Arrays;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        /**
         * 遍历数组，每个数字给它计数，如果相等就 + 1，如果不等就 - 1，计数到0了就换个数重新开始计数
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */
