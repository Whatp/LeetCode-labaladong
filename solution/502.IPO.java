/*
 * @lc app=leetcode.cn id=502 lang=java
 * @lcpr version=30202
 *
 * [502] IPO
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int curr = 0;
        int[][] arr = new int[len][2];
        // 建立一个profits和captial的二维数组,他们之间是存在对应的关系的
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        // 所需的资产最小,符合的都把利润加入到大顶堆中,所以应该是根据资产排序
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // 默认是小顶堆,要用大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            // 
            while (curr < len && arr[curr][0] <= w) {
                pq.offer(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }
        return w;

    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n0\n[1,2,3]\n[0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// 3\n0\n[1,2,3]\n[0,1,2]\n
// @lcpr case=end

 */

