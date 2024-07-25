package array;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ArrayReduce.java
 * @project Basic
 * @package array
 * @date 2024/7/25 23:56
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayReduce {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (arr.length == 1) {
                System.out.println("只剩一个元素，不能再缩减");
                break;
            } else {
                int[] reduceArr = new int[arr.length - 1];
                for (int i = 0; i < reduceArr.length; i++) {
                    reduceArr[i] = arr[i];
                }
                arr = reduceArr;
                System.out.print("缩容结果:");
                for (int i : arr) {
                    System.out.print(i + "\t");
                }
                System.out.println("\n缩容成功，是否继续？y/n");
                char choose = sc.next().charAt(0);
                if (choose == 'n') {
                    System.out.println("程序结束");
                    break;
                } else if (choose == 'y') {
                    System.out.println("程序继续");
                } else {
                    System.out.println("输入错误，程序结束");
                    break;
                }
            }
        }
    }
}
