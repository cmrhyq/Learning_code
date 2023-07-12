package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：移除元素</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&id=top-interview-150">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname RemoveElement.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/16 23:42
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class RemoveElement {

    /**
     * <div>
     *     <p>双指针</p>
     *     <p>
     *         右指针right指向当前将要处理的元素，左指针只想下一个将要赋值的元素的位置
     *     </p>
     *     <ul>
     *         <li>如果右指针的元素不等于val，那么代表了它一定是输出数组中的元素，那么就需要将右指针只想的元素复制到左指针指向的位置上，同时将左右指针向右移动</li>
     *         <li>如果右指针的元素等于val,那么代表了它不在输出数组中，那么左指针不动，右指针向右移动</li>
     *     </ul>
     * </div>
     *
     * @param nums 数组
     * @param val  需要删除的元素
     * @return 删除元素后的数组长度
     */
    public int removeElement(int[] nums, int val) {
        // 获取数组长度并声明一个左指针
        int n = nums.length;
        int left = 0;
        // 声明一个右指针并且右指针最大不超过数组长度
        for (int right = 0; right < n; right++) {
            // 判断当前处理的元素是否等于需要删除的元素
            if (nums[right] != val) {
                // 将当前处理的元素的值赋值到数组中下一个将要赋值的元素的位置上
                nums[left] = nums[right];
                // 左指针向后走一步
                left++;
            }
        }

        return left;
    }
}
