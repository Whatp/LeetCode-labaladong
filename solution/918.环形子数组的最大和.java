/*
 * @lc app=leetcode.cn id=918 lang=java
 * @lcpr version=30202
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    /**
     * 环形数组的解法通常考虑两种情况：

    ​   ​最大子数组不跨越首尾​​：等同于普通Kadane算法的结果
       ​最大子数组跨越首尾​​：总和 - 最小子数组和

       整个数组的和是常数,如果求解的最大和没有跨越首尾,就是普通解法
       如果跨越了首尾,这个和要想大,剩下的和就得小,所以求一个全局的最小和,用sum - 全局最小和
       当然,如果整个数组全是负数,最小数组和就是整个数组,相减就成零了,这个需要单独考虑
    */


    public int maxSubarraySumCircular(int[] nums) {
        int max_current = nums[0], max_global = nums[0];
        int min_current = nums[0], min_global = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_current = Math.max(nums[i], max_current + nums[i]);
            max_global = Math.max(max_global, max_current);

            min_current = Math.min(min_current + nums[i], nums[i]);
            min_global = Math.min(min_current, min_global);
            sum += nums[i];
        }
        // 有可能和是负值,这时候直接返回max_global
        if (max_global < 0) {
            return max_global;
        }
        
        return Math.max(max_global, sum - min_global);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,-2,3,-2]\n
// @lcpr case=end

// @lcpr case=start
// [5,-3,5]\n
// @lcpr case=end

// @lcpr case=start
// [3,-2,2,-3]\n
// @lcpr case=end

 */

