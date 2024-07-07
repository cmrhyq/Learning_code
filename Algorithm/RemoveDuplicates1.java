package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：删除有序数组中的重复项</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname RemoveDuplicates1.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/24 9:06
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class RemoveDuplicates1 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int fast = 2, slow = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
