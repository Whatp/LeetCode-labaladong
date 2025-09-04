/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30201
 *
 * [139] 单词拆分
 */

// @lc code=start

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dp[i]我们先明确dp数组的含义，前i个字符可以用wordDict单词表示，也就是可以被拆分
         * 如果dp[j]为true（即前j个字符可以被拆分），并且s.substring(j, i)在字典中，则dp[i]为true
         */
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] &&wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
// @lc code=end



/*
// @lcpr case=start
// "leetcode"\n["leet", "code"]\n
// @lcpr case=end

// @lcpr case=start
// "applepenapple"\n["apple", "pen"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats", "dog", "sand", "and", "cat"]\n
// @lcpr case=end

 */

