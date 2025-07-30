/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30202
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (s.charAt(i) == ')' && c != '(' ||
                s.charAt(i) == ']' && c != '[' ||
                s.charAt(i) == '}' && c != '{'
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "()"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "()[]{}"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "(]"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "([])"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "([)]"\n
 * // @lcpr case=end
 * 
 */
