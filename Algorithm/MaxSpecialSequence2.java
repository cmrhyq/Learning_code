package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：最长特殊序列 2</p>
 * <p>讲解请见MarkDown文档中的 最长特殊序列2 部分</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/longest-uncommon-subsequence-ii/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname MaxSpecialSequence2.java
 * @project LeetCode
 * @package com.cmrhyq.learning.LeetCode
 * @date 2024/7/8 0:16
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class MaxSpecialSequence2 {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        // 使用一个双重循环，外层枚举每一个字符串 str[i] 作为特殊序列，内层枚举每一个字符串 str[j]，判断 str[i] 是否不为 str[j] 的子序列即可。
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                // 在所有满足isSubSeq方法的strs[i]中选择最长的一个作为答案，如果不满足，则返回-1
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        // 定义两个指针
        int ptS = 0, ptT = 0;
        // 两个指针指向的位置要小于两个字符串的长度
        while (ptS < s.length() && ptT < t.length()) {
            // 两个指针对s、t两个字符串一位接一位的比对
            // 如果两个比对的字符当前位都相同则都往右移动一位
            // 如果ptT指针向右移动则表示匹配失败
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        // 判断ptS指针是否遍历了整个字符串，如果是则代表字符串s是字符串t的子序列
        return ptS == s.length();
    }
}
