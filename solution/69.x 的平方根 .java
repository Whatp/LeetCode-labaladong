/*
 * @lc app=leetcode.cn id=69 lang=java
 * @lcpr version=30202
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        if (x < 2) return x;
        
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == x) return (int)mid;
            if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)right;
// 时间复杂度: O(logx)
// 空间复杂度: O(1)
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 8\n
// @lcpr case=end

 */

