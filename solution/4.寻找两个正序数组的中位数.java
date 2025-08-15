/*
 * @lc app=leetcode.cn id=4 lang=java
 * @lcpr version=30202
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if (total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, (total + 1) / 2); // 奇数长度，直接返回第k个
        } else {
            int left = findKth(nums1, 0, nums2, 0, total / 2); // 偶数长度，返回中间两数的平均值
            int right = findKth(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 边界条件1：nums1已全部排除
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        // 边界条件2：nums2已全部排除
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        // 边界条件3：k=1时直接比较当前最小元素
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        // 取两个数组的中间位置（避免越界）
        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        // 递归核心：比较mid1和mid2，排除不可能的部分
        if (mid1 < mid2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2); // 排除nums1的前k/2个元素
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2); // 排除nums2的前k/2个元素
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3]\n[2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n[3,4]\n
 * // @lcpr case=end
 * 
 */
