/*
 * @lc app=leetcode.cn id=373 lang=java
 * @lcpr version=30202
 *
 * [373] 查找和最小的 K 对数字
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // 使用优先队列，按和的大小排序（最小堆）
        // FIXED: 添加了比较器来定义优先队列的排序规则
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // 初始化：将nums1的前k个元素与nums2的第一个元素配对
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        
        while (result.size() < k) {
            int[] current = pq.poll();
            int i = current[1];  // nums1中的索引
            int j = current[2];  // nums2中的索引
            
            // FIXED: 添加正确的列表元素
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            result.add(pair);
            
            
            // 如果当前nums2索引还有下一个元素，将其加入队列
            if (j + 1 < nums2.length) {
                // FIXED: 使用offer而不是add（两者功能相同，但offer是Queue接口的标准方法）
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        
        return result;
    }
}

// @lc code=end



/*
// @lcpr case=start
// [1,7,11]\n[2,4,6]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2]\n[1,2,3]\n2\n
// @lcpr case=end

 */

