/*
 * @lc app=leetcode.cn id=135 lang=java
 * @lcpr version=30201
 *
 * [135] 分发糖果
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2]\n
 * // @lcpr case=end
 * 
 */
