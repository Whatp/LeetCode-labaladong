/*
 * @lc app=leetcode.cn id=380 lang=java
 * @lcpr version=30201
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    private List<Integer> nums;
    // 存储元素在List中的索引
    private Map<Integer, Integer> valToIndex;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;

        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastElement = nums.get(nums.size() - 1);
        // 交换index对应的值和最后一个元素
        valToIndex.put(lastElement, index);
        // 索引对应位置设置成最后一个元素
        nums.set(index, lastElement);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
