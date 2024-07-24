package array;

import java.io.IOException;
import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ArrayAdd.java
 * @project Basic
 * @package array
 * @date 2024/7/25 0:03
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayAdd {

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个数");
            int input = sc.nextInt();
            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = input;
            arr = newArr;
            System.out.print("扩容结果:");
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println("\n添加成功，是否继续？y/n");
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
