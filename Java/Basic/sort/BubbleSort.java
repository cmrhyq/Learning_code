package sort;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname BubbleSort.java
 * @project Basic
 * @package sort
 * @date 2024/7/26 0:51
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] bubble = {24, 69, 80, 57, 13};
        // 根据分析得知，冒泡排序只会进行 数组长度 - 1 次
        // 所以，用外层for控制排序的轮数
        for (int j = 0; j < bubble.length - 1; j++) {
            // 用内层for控制每次排序的比较次数, 每次排序的比较次数 = 数组长度 - 当前排序轮数
            for (int i = 0; i < (bubble.length - 1) - j; i++) {
                if (bubble[i] > bubble[i + 1]) {
                    // 用临时变量来实现交换
                    int temp = bubble[i];
                    bubble[i] = bubble[i + 1];
                    bubble[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i] + "\t");
        }
    }
}
