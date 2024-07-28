package array;

import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname YanghuiTriangle.java
 * @project Basic
 * @package array
 * @date 2024/7/28 23:40
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class YangHuiTriangle {

    /**
     * - 第一行有1个元素，第N行有N个元素
     * - 每一行的第一个和最后一个元素都是1
     * - 从第三行开始，对于非第一个元素和最后一个元素的值都是 arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter line number");
        int line = sc.nextInt();
        int[][] triangle = new int[line][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0 || j == triangle[i].length - 1) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }

        for (int[] triangles : triangle) {
            for (int anInt : triangles) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
