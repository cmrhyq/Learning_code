package com.cmrhyq.learning.LeetCode;

import java.util.HashMap;

/**
 * <p>Leet Code 算法题：罗马数字转整数</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/roman-to-integer">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname RomanNumberToNumber.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/12 15:50
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class RomanNumberToNumber {

    /**
     *
     * 首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
     *
     * @param s roman number
     * @return int
     */
    public static int romanToInt(String s) {
        // 获取字符长度、声明最后的结果
        int strLength = s.length();
        int intNum = 0;

        // 定义一个hashmap，罗马字符为key，对应的整数为value
        HashMap<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        // 循环整个输入的字符 s
        for (int i = 0; i < strLength; i++) {
            // 获取当前循环所对应的罗马字符
            String str = String.valueOf(s.charAt(i));
            // 判断当前次数是否大于 （字符s的长度 -1），防止越界
            if (i < strLength - 1) {
                // 获取当前循环所对应的字符的下一个罗马字符
                String str1 = String.valueOf(s.charAt(i + 1));
                // 判断当前罗马字符对应的整数是否 < 下一次循环的罗马字符对应的整数
                // 如果小于，根据罗马字符换算规则如下进行换算：
                // 如果罗马数字中小的数字在大的数字的右边，则两数相加
                // 如果大于，根据罗马字符换算规则如下进行换算：
                // 如果罗马数字中小的数字在大的数字的左边，则大数减小数
                if (romanMap.get(str) < romanMap.get(str1)) {
                    intNum -= romanMap.get(str);
                } else {
                    intNum += romanMap.get(str);
                }
            } else {
                intNum += romanMap.get(str);
            }
        }
        return intNum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
