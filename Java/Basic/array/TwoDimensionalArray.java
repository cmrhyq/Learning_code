package array;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TwoDimensionalArray.java
 * @project Basic
 * @package array
 * @date 2024/7/28 2:12
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = new int[3][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];

            Arrays.fill(arr[i], i + 1);
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
