package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：价格优惠</p>
 * <p>讲解请见MarkDown文档中的 价格优惠 部分</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/apply-discount-to-prices/description/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname DiscountPrice.java
 * @project LeetCode
 * @package com.cmrhyq.learning.LeetCode
 * @date 2024/7/8 0:32
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class DiscountPrice {

    /**
     * 价格的特点：以 $ 开头，后续至少有一个字符，且均在 [0,9] 中；
     * @param sentence 句子
     * @param discount 优惠
     * @return sentence
     */
    public static String discountPrices(String sentence, int discount) {
        // 利用空格将句子分割
        String[] words = sentence.split(" ");
        // 一段一段的判断
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // 判断是否以 $ 开头，并且后面的字符是否都是数字，如果是的话，则代表这是一个价格
            if (word.charAt(0) == '$' && isNumeric(word.substring(1))) {
                // 计算优惠后的价格
                double price = Long.parseLong(word.substring(1)) * (1 - discount / 100.0);
                // 将结果替换回去
                words[i] = String.format("$%.2f", price);
            }
        }
        StringBuilder sb = new StringBuilder();
        // 将分割的每段加上空格拼接回去
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    /**
     * 通过指针判断是否为数字
     *
     * @param s 字符
     * @return true or false
     */
    public static boolean isNumeric(String s) {
        if (s.isEmpty()) {
            return false;
        }
        // 一位一位的右移判断是否为数字，如果有一位不是则代表整个都不是
        for (int i = 0; i < s.length(); i++) {
            // isDigit方法：判断是否为数字
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String sentence = "ka3caz4837h6ada4 r1 $602";
        int discount = 9;
        System.out.println(discountPrices(sentence, discount));
    }
}
