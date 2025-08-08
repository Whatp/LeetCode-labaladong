
/*
 * @lc app=leetcode.cn id=210 lang=java
 * @lcpr version=30202
 *
 * [210] 课程表 II
 */
import java.util.*;

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /**
         * 和课程表1不一样的在于我们要把这个拓扑排序输出
         */
        int[] res = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            // a b 分别是后修和先修
            int a = i[0];
            int b = i[1];
            list.get(b).add(a);
            // 入度 + 1
            inDegree[a]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        // 把所有入度为0的节点加进去，从拓扑排序中，入度为0的节点是头
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                // i的位置就是入度为0的节点，也就是没有先修条件的课程
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            ans.add(course);
            // 要把课程删了，然后把它后续所有的课程的入度都 - 1 ,取出后续, 如果入度为0了，还要再加到邻接表
            for (int next : list.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }

        }
        if (count != numCourses) {
            // 返回空数组，而不是默认值，一开始初始化成int[1]，会给默认值
            return new int[0];
        }
        return ans.stream().mapToInt(i -> i).toArray();

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n[[1,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n[[1,0],[2,0],[3,1],[3,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n[]\n
 * // @lcpr case=end
 * 
 */
