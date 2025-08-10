/*
 * @lc app=leetcode.cn id=127 lang=java
 * @lcpr version=30202
 *
 * [127] 单词接龙
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    static class Pair {
        String word;
        int steps;

        Pair(String w, int s) {
            word = w;
            steps = s;
        }

    }

    /**
     * 找到一个最短的转换序列，用BFS，将每个单词视为图中的一个节点，每次到下一个节点只改变一个字符
     * 将wordList转换为set，方便查询，如果转换后的在set中，加到BFS队列中，并且把它从set中移除，
     * 如果找不到就返回0
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            // 对当前的单词进行遍历，尝试修改每一个字符，找到在set中对应的，加入队列，移除set
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char origianl = chars[i];
                for (char c : alphabet) {
                    if (c == origianl) {
                        continue;
                    }
                    // 修改当前单词
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        queue.offer(new Pair(newWord, steps + 1));
                        wordSet.remove(newWord);
                    }
                }
                chars[i] = origianl;
            }
        }
        return 0;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "hit"\n"cog"\n["hot","dot","dog","lot","log"]\n
 * // @lcpr case=end
 * 
 */
