/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=30202
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class Solution {
    /**
     * 「快速选择」：设 N 为数组长度。根据快速排序原理，如果某次哨兵划分后，
     * 基准数的索引正好是 N−k ，则意味着它就是第 k 大的数字 。此时就可以直接返回它，无需继续递归下去了。
     * 
     * 然而，对于包含大量重复元素的数组，每轮的哨兵划分都可能将数组划分为长度为 1 和 n−1 的两个部分，
     * 这种情况下快速排序的时间复杂度会退化至 O(N^2) 。
     * 
     * 一种解决方案是使用「三路划分」，即每轮将数组划分为三个部分：小于、等于和大于基准数的所有元素。
     * 这样当发现第 k 大数字处在“等于基准数”的子数组中时，便可以直接返回该元素。
     * 
     * 为了进一步提升算法的稳健性，我们采用随机选择的方式来选定基准数。
     * 
     * @param nums
     * @param k
     * @return
     */
    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (big.size() + equal.size() < k)
            return quickSelect(small, k - (big.size() + equal.size()));
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }
}


class Solution2 {
    /**
    可以把小顶堆 pq 理解成一个筛子，较大的元素会沉淀下去，较小的元素会浮上来；
    当堆大小超过 k 的时候，我们就删掉堆顶的元素，因为这些元素比较小，而我们想要的是前 k 个最大元素嘛。
    
    当 nums 中的所有元素都过了一遍之后，筛子里面留下的就是最大的 k 个元素，
    而堆顶元素是堆中最小的元素，也就是「第 k 个最大的元素」。
    
    二叉堆插入和删除的时间复杂度和堆中的元素个数有关，在这里我们堆的大小不会超过 k，
    所以插入和删除元素的复杂度是 O(logK)，再套一层 for 循环，总的时间复杂度就是 O(NlogK)。
     */
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            // 每个元素都要过一遍二叉堆
            pq.offer(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.peek();
    }
}

// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 */
