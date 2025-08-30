/*
 * @lc app=leetcode.cn id=9 lang=java
 * @lcpr version=30202
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(int x) {
        // 如果x不是0，但是最后一位是0，返回false
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        
        int revert = 0;
        // 我们只反转一半
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }

        return x == revert || x == revert / 10;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// -121\n
// @lcpr case=end

// @lcpr case=start
// 10\n
// @lcpr case=end

 */

