/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30202
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
        BFS，可以把课程及其关系看成一个寻找有向无环图的过程，只要有一个符合要求，就可以
        我们用list存储前提课程和它的后续的课程，用数组存储所有入度为0的课程，
        当一个节点入度为0的时候，就把记录 + 1，如果记录和课程数相等，返回true
         */
        //  存储映射关系
        List<List<Integer>> list = new ArrayList<>();
        // 入度为0的节点
        int[] inDegree = new int[numCourses];
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            // 分别是后修和先修课程
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            // 邻接表中，b是下标，对应位置存储后修 0 -> [1, 2]，表示修1 2 之前先修0
            list.get(b).add(a);
            // 入度 + 1
            inDegree[a]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        // 所有入度为0的节点入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0; // 记录所有学了的课程
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // 把这个课程删了，相当于删了一条边，那么后面的节点就少了入度，把后面的节点入度 - 1
            for (int next : list.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;

    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

