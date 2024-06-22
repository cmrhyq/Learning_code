/**
 * <h3>题目：价格优惠</h3>
 * <p>句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
 * <p>
 * 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
 * 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * <p>
 * 返回表示修改后句子的字符串。
 * <p>
 * 注意：所有价格 最多 为  10 位数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
 * </p>
 * 输出："there are $0.50 $1.00 and 5$ candies in the shop"
 * <p>解释：</p>
 * <p>表示价格的单词是 "$1" 和 "$2" 。</p>
 * <p>- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。</p>
 * <p>- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。</p>
 * </p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname Solution240618.java
 * @project leetcode
 * @package PACKAGE_NAME
 * @date 2024/6/18 22:52
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Solution240618 {

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
