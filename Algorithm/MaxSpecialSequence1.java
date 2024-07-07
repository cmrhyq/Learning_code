package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：最长特殊序列 1</p>
 * <p>讲解请见MarkDown文档中的 最长特殊序列1 部分</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/description/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname SepcialSequence.java
 * @project LeetCode
 * @package com.cmrhyq.learning.LeetCode
 * @date 2024/7/8 0:12
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class MaxSpecialSequence1 {

    public int findLUSlength(String a, String b) {
        // Math.max方法：max() 方法用于返回两个参数中的最大值。
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
