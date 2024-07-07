package com.cmrhyq.learning.LeetCode;

import java.util.Arrays;

/**
 * <p>Leet Code 算法题：数组中重复的数字</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname FindRepeatNumber.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/16 1:05
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class FindRepeatNumber {

    /**
     *
     * @param nums 需要筛选的数组
     * @return 重复的数字
     */
    public static int findRepeatNumber(int[] nums) {
        // 先将数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 判断数组当前数字是否等于数组下一个数字
            // 如果等于就代表数字重复
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
