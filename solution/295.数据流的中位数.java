/*
 * @lc app=leetcode.cn id=295 lang=java
 * @lcpr version=30202
 *
 * [295] 数据流的中位数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) == num) {
                left = mid;
                break;
            } else if (list.get(mid) < num) {
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        list.add(left, num);
    }
    
    public double findMedian() {
        int n = list.size();
        if (n == 0) {
            return 0.0;
        }

        if (n % 2 == 1) {
            return list.get(n / 2);
        } else {
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end



