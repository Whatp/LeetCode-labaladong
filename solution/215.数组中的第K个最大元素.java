/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=30202
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
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
