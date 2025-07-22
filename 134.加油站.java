/*
 * @lc app=leetcode.cn id=134 lang=java
 * @lcpr version=30201
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * 总的油量要大于总的消耗
         * 如果当前的油量无法到达下一个加油站，就直接从下一个开始
         */
        int n = gas.length;
        int total_gas = 0, total_cost = 0;
        int current_gas = 0, start = 0;

        for (int i = 0; i < n; i++) {
            total_cost += cost[i];
            total_gas += gas[i];
            current_gas += gas[i] - cost[i];
            if (current_gas < 0) {
                start = i + 1;
                current_gas = 0;
            }
        }
        if (total_cost > total_gas) return -1;
        
        return start;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n[3,4,5,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,4]\n[3,4,3]\n
// @lcpr case=end

 */

