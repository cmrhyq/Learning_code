package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：判断两个事件是否存在冲突</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname HaveConflist.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/17 14:27
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class HaveConflict {

    /**
     * <ul>
     *     <li>题目说明
     *         <ul>
     *              <li>evnet1.length == event2.length == 2.</li>
     *              <li>event1[i].length == event2[i].length == 5</li>
     *              <li>startTime1 <= endTime1</li>
     *              <li>startTime2 <= endTime2</li>
     *              <li>所有事件的时间都按照 HH:MM 格式给出</li>
     *         </ul>
     *     </li>
     *     <li>compareTo方法
     *          <ul>作用
     *              <li>1.字符串与对象的比较</li>
     *              <li>2.按字典顺序比较两个字符串</li>
     *          </ul>
     *          <ul>语法
     *              <li>int n = str1.compareTo(str2)</li>
     *          </ul>
     *          <ul>返回值
     *              <li>如果参数字符串等于此字符串，则返回值 0</li>
     *              <li>如果此字符串小于字符串参数，则返回一个小于 0 的值</li>
     *              <li>如果此字符串大于字符串参数，则返回一个大于 0 的值</li>
     *          </ul>
     *     </li>
     * </ul>
     * @param event1 [startTime1, endTime1]
     * @param event2 [startTime2, endTime2]
     * @return true or false
     */
    public static boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
