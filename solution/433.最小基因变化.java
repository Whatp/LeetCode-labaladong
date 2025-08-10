/*
 * @lc app=leetcode.cn id=433 lang=java
 * @lcpr version=30202
 *
 * [433] 最小基因变化
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    /**
     * 这种最短路径问题适合用BFS解决，，将每个基因视为图中的节点，若两个节点
     * 仅有一个字符不同，则它们之间存在边，按层遍历，首次到达目标序列的路径必然是最短路径
     * 
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    static class Pair {
        String gene;
        int steps;

        Pair(String g, int s) {
            gene = g;
            steps = s;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        // 将基因库转成set，方便查询
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }
        // 初始化BFS队列，并且把初始gene放入
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));
        bankSet.remove(startGene); // 移除startGene，避免重复访问

        char[] geChar = { 'A', 'G', 'C', 'T' };

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String gene = curr.gene;
            int steps = curr.steps;

            if (gene.equals(endGene))
                return steps;

            // 修改基因的每个位置，判断是否在基因序列中，如果在，加入到队列中，在基因序列中移除
            char[] geneArr = gene.toCharArray();
            for (int i = 0; i < geneArr.length; i++) {
                // 原始的字符，用于回溯
                char orngianl = geneArr[i];
                // 碱基中的每个字符
                for (char c : geChar) {
                    if (c == orngianl)
                        continue;
                    // 每次替换一个字符，看看新字符是否在基因序列中
                    geneArr[i] = c;
                    String newGene = new String(geneArr);

                    if (bankSet.contains(newGene)) {
                        queue.offer(new Pair(newGene, steps + 1));
                        bankSet.remove(newGene);
                    }
                }
                geneArr[i] = orngianl;
            }
        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "AACCGGTT"\n"AAACGGTA"\n["AACCGGTA","AACCGCTA","AAACGGTA"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "AAAAACCC"\n"AACCCCCC"\n["AAAACCCC","AAACCCCC","AACCCCCC"]\n
 * // @lcpr case=end
 * 
 */
