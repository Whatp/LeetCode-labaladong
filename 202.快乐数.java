/*
 * @lc app=leetcode.cn id=202 lang=java
 * @lcpr version=30201
 *
 * [202] 快乐数
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            int sum = 0;
            set.add(n);
            while (n > 0) {
                int a = n % 10;
                sum += a * a;
                n /= 10;
            }
            n = sum;
        }

        return n == 1;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // 19\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 */
