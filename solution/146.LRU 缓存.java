/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30202
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.LinkedHashMap;

class LRUCache {
    /**
     * 哈希表查找快，但是没有固定顺序，链表有顺序之分，但是查找慢
     * 结合二者，形成一种新的数据结构
     * 
     */
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 查找之后要把该元素变成最近使用过的
        makeRecetly(key);
        return cache.get(key);

    }

    public void put(int key, int val) {
        // 已经存在了，不需要判断size
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecetly(key);
            return;
        }
        if (cache.size() >= this.cap) {
            int oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
        cache.put(key, val);
    }

    private void makeRecetly(int key) {
        // 从哈希链表中删除再添加
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
