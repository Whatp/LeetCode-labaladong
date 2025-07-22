/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30201
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    /**
     * n数之和，起始位置是start，目标和是target
     * 
     * @param nums
     * @param n
     * @param start
     * @param target
     * @return
     */
    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        // base case
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < 2)
            return res;

        // base case，其他情况就是进行递归计算
        if (n == 2) {
            // 当前的两个指针
            int currL = start, currR = len - 1;
            while (currL < currR) {
                int sum = nums[currL] + nums[currR];
                // 记录已经访问过的数字，方便去重的
                int left = nums[currL], right = nums[currR];
                // 已经排过序了，如果和比target小，说明要左移指针
                if (sum < target) {
                    while (currL < currR && nums[currL] == left) {
                        currL++;
                    }
                } else if (sum > target) {
                    while (currL < currR && nums[currR] == right) {
                        currR--;
                    }
                } else {
                    // 去重
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (currL < currR && nums[currL] == left) {
                        currL++;
                    }
                    while (currL < currR && nums[currR] == right) {
                        currR--;
                    }
                }
            }
        } else {
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                // 去重的
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    /**
     * 正常的双指针做法，关键在于去重
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 提前终止，nums[i]已经大于零了，三个数都是正数，加起来不会等于零
            if (nums[i] > 0 && nums[i] == nums[i + 1])
                continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-1,0,1,2,-1,-4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,0,0]\n
 * // @lcpr case=end
 * 
 */
