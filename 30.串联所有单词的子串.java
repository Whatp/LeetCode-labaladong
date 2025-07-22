/*
 * @lc app=leetcode.cn id=30 lang=java
 * @lcpr version=30201
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /**
         * 用List记录答案，一个哈希表记录每个单词出现的次数，
         * 一个哈希表记录窗口内出现的单词
         */
        List<Integer> res = new ArrayList<>();
        // 单词数
        int totalWords = words.length;
        // 每个单词的长度
        int wordLen = words[0].length();

        // 记录单词出现的次数，这个次数必须和窗口内出现的次数相等
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            // 记录当前窗口的单词
            Map<String, Integer> winMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String subWord = s.substring(right, right + wordLen);
                right += wordLen;

                if (countMap.containsKey(subWord)) {
                    winMap.put(subWord, winMap.getOrDefault(subWord, 0) + 1);
                    count++;
                    // 当前单词的次数多了，需要移动左边界
                    while (countMap.get(subWord) < winMap.get(subWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        left += wordLen;
                        winMap.put(leftWord, winMap.get(leftWord) - 1);
                        count--;
                    }
                    if (count == totalWords) {
                        res.add(left);
                    }
                } else {
                    winMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "barfoothefoobarman"\n["foo","bar"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
 * // @lcpr case=end
 * 
 */
