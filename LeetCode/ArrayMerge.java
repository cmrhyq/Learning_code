package com.cmrhyq.learning.LeetCode;

import java.util.Arrays;

/**
 * <p>Leet Code 算法题：合并两个有序数组</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&id=top-interview-150">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ArrayMerge.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/16 11:30
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayMerge {

    /**
     * 将nums2 放到nums1 的后面然后直接将nums1 排序
     * 时间复杂度度：O((m+n)log(m+n))
     * 空间复杂度：O(log(m+n))
     *
     * @param nums1 数组1
     * @param m     数组1的元素数目
     * @param nums2 数组2
     * @param n     数组2的元素数目
     */
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i != n; ++i) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//    }

    /**
     * 利用两个数组已经排序的性质，将nums1 和nums2 数组头部取出比较的数字放到结果中
     * 时间复杂度度：O((m+n)log(m+n))
     * 空间复杂度：O(log(m+n))
     *
     * @param nums1 数组1
     * @param m     数组1的元素数目
     * @param nums2 数组2
     * @param n     数组2的元素数目
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int p1 = 0, p2 = 0;
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; i++) {
            nums1[i] = sorted[i];
        }
    }
}
