/*
 * @lc app=leetcode.cn id=228 lang=java
 * @lcpr version=30201
 *
 * [228] 汇总区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        /**
         * 区间有序,如果相差为1，移动指针，不为1的话判断两个指针是否相等
         */
        int left = 0, right = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            // 这里很重要，一开始写成了nums[right] - nums[left] == 1，应该判断相邻元素
            if (nums[i] - nums[i - 1] == 1) {
                right = i;
            } else {
                if (left == right) {
                    res.add(String.valueOf(nums[left]));
                } else {
                    res.add(nums[left] + "->" + nums[right]);
                }
                left = i;
                right = i;
            }
        }

        if (left == right) {
            res.add(String.valueOf(nums[left]));
        } else {
            res.add(nums[left] + "->" + nums[right]);
        }

        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,2,4,5,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,2,3,4,6,8,9]\n
 * // @lcpr case=end
 * 
 */
