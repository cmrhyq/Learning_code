package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：删除有序数组中的重复项</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname RemoveDuplicates.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/23 15:44
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class RemoveDuplicates {

    /**
     * <div>
     *     <p>注意：</p>
     *     <ul>
     *         <li>更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要</li>
     *         <li>返回 k</li>
     *     </ul>
     * </div>
     *
     * @param nums 升序排序的数组
     * @return 删除重复项以后的唯一元素的数组长度
     */
    public int removeDuplicates(int[] nums) {
        // 获取数组长度
        int n = nums.length;
        // 判断数组长度如果等于0 则直接返回0
        if (n == 0) {
            return 0;
        }
        // 初始化快指针和慢指针，赋初值1
        int fast = 1, slow = 1;
        // 循环至快指针等于数组长度结束
        while (fast < n) {
            // 判断快指针指向的值和上一个值对比
            if (nums[fast] != nums[fast - 1]) {
                // 如果快指针指向的值和上一个值不一样，则将快指针的值赋给慢指针上
                nums[slow] = nums[fast];
                // 慢指针指向下一位
                ++slow;
            }
            // 快指针指向下一位
            ++fast;
        }
        return slow;
    }
}
