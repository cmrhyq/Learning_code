package com.cmrhyq.learning.LeetCode;

/**
 * <p>Leet Code 算法题：处理用时最长的那个任务的员工</p>
 * <div>
 * <p>来源：力扣（LeetCode）</p>
 * <p>链接：<a href="https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/">相关地址</a></p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname HeadestWorker.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.LeetCode
 * @date 2023/5/23 10:24
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class HardestWorker {

    /**
     * <div>
     *     <p>注意：</p>
     *     <ul>
     *         <li>第 i个任务在第 (i-1)个任务结束后立即开始，且第 0个任务从时刻0开始</li>
     *         <li>如果存在两个或多个员工同时满足“处理用时最长”的条件，则返回几人中最小的ID</li>
     *     </ul>
     *     <p>logs参数说明：</p>
     *     <ul>
     *         <li>[[id1, leaveTime1],[id2, leaveTime2],...]</li>
     *         <li>id是处理第i个任务的员工id</li>
     *         <li>leaveTime是员工完成第 i个任务的时刻，所有的 leaveTime都是唯一的</li>
     *     </ul>
     * </div>
     *
     * @param n n位员工
     * @param logs 任务信息二维数组
     * @return 任务处理用时最长的员工ID
     */
    public static int hardestWorker(int n, int[][] logs) {
        // maxCost 最大的处理时间
        // ans 最大处理时间的员工id
        // 最大的处理时间和最大处理时间的员工id最开始就可以确定，所有将这两个值从logs中取出并赋值
        int maxCost = logs[0][1], ans = logs[0][0];
        // 从1开始往下循环，循环到logs.length，先执行for中的代码再进行++
        for (int i = 1; i < logs.length; ++i) {
            // 获取当前的员工号和当前任务处理时间
            int index = logs[i][0];
            // 当前任务处理时间为 本次任务结束时间 - 上一次任务结束时间
            int cost = logs[i][1] - logs[i - 1][1];
            // 判断当前任务处理时间是否大于最大的任务处理时间
            // 或者 在当前任务时间等于最大任务时间时，当前员工id要小于最大员工id
            if (cost > maxCost || (cost == maxCost && index < ans)){
                maxCost = cost;
                ans = index;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        System.out.println(hardestWorker(10, logs));
    }
}
