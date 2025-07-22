/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30201
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,7,11,15]\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,4]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,3]\n6\n
 * // @lcpr case=end
 * 
 */
