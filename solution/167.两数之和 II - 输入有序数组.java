/*
 * @lc app=leetcode.cn id=167 lang=java
 * @lcpr version=30201
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        throw new IllegalArgumentException();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,7,11,15]\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,4]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,0]\n-1\n
 * // @lcpr case=end
 * 
 */
