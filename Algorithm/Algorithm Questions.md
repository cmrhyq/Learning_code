<div style="font-family: 'Kanit', sans-serif;text-align: center;border: 10px solid #fff;box-shadow: 1px 1px 2px #e6e6e6;background: linear-gradient(to left top, #11998e, #38ef7d); padding: 50px 0;">
<div style="color: #fff;">
    <h3 style="font-size: 25px;font-weight: 600;letter-spacing: 1px;text-transform: uppercase;margin: 0;">
       Algorithm Question
    </h3>
    <span style="font-size: 16px;text-transform: capitalize;">
    	算法题目
    </span>
</div>
</div>


[toc]

## 最长特殊序列Ⅰ

给你两个字符串 `a` 和 `b`，请返回 *这两个字符串中 **最长的特殊序列*** 的长度。如果不存在，则返回 `-1` 。

**「最长特殊序列」** 定义如下：该序列为 **某字符串独有的最长**

**子序列**

**（即不能是其它字符串的子序列）** 。

字符串 `s` 的子序列是在从 `s` 中删除任意数量的字符后可以获得的字符串。

- 例如，`"abc"` 是 `"aebdc"` 的子序列，因为删除 `"aebdc"` 中的`ed`字符可以得到 `"abc"` 。 `"aebdc"` 的子序列还包括 `"aebdc"` 、 `"aeb"` 和 `""` (空字符串)。

**示例 1：**

```
输入: a = "aba", b = "cdc"
输出: 3
解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
```

**示例 2：**

```
输入：a = "aaa", b = "bbb"
输出：3
解释: 最长特殊序列是 "aaa" 和 "bbb" 。
```

**示例 3：**

```
输入：a = "aaa", b = "aaa"
输出：-1
解释: 字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。
```

**提示：**

- `1 <= a.length, b.length <= 100`
- `a` 和 `b` 由小写英文字母组成

**解析**

1. 字符串的子序列的长度不会超过该字符串的长度。
2. 如果子序列的长度等于该字符串的长度，那么子序列就是该字符串
3. 字符串不相同长度也不相同时，可以选择较长的字符串当作最长特殊序列，因为它不会是较短字符串的子序列
4. 字符串不相同但是长度相同时，仍然可以选择一个字符串作为最长特殊字符串，它不会是另一个字符串的子序列
5. 字符串相同长度也相同时，那么任意一个子序列就会出现在两个字符串中，那么就是 -1

```java
class Solution {
    public int findLUSlength(String a, String b) {
        // Math.max方法：max() 方法用于返回两个参数中的最大值。
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
```



## 最长特殊序列Ⅱ

给定字符串列表 `strs` ，返回其中 **最长的特殊序列** 的长度。如果最长特殊序列不存在，返回 `-1` 。

**特殊序列** 定义如下：该序列为某字符串 **独有的子序列（即不能是其他字符串的子序列）**。

 `s` 的 **子序列**可以通过删去字符串 `s` 中的某些字符实现。

- 例如，`"abc"` 是 `"aebdc"` 的子序列，因为您可以删除`"aebdc"`中的下划线字符来得到 `"abc"` 。`"aebdc"`的子序列还包括`"aebdc"`、 `"aeb"` 和 "" (空字符串)。

**示例 1：**

```
输入: strs = ["aba","cdc","eae"]
输出: 3
```

**示例 2:**

```
输入: strs = ["aaa","aaa","aa"]
输出: -1
```

**提示:**

- `2 <= strs.length <= 50`
- `1 <= strs[i].length <= 10`
- `strs[i]` 只包含小写英文字母

**解析**

```java
class Solution {
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
```



## 价格优惠

**句子** 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 `'$'` 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 **价格** 。

- 例如 `"$100"`、`"$23"` 和 `"$6"` 表示价格，而 `"100"`、`"$"` 和 `"$1e5` 不是。

给你一个字符串 `sentence` 表示一个句子和一个整数 `discount` 。对于每个表示价格的单词，都在价格的基础上减免 `discount%` ，并 **更新** 该单词到句子中。所有更新后的价格应该表示为一个 **恰好保留小数点后两位** 的数字。

返回表示修改后句子的字符串。

注意：所有价格 **最多** 为 `10` 位数字。

**示例 1：**

```
输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
输出："there are $0.50 $1.00 and 5$ candies in the shop"
解释：
表示价格的单词是 "$1" 和 "$2" 。 
- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
```

**示例 2：**

```
输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
解释：
任何价格减免 100% 都会得到 0 。
表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
每个单词都替换为 "$0.00"。
```

**解析**

```java
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
```
