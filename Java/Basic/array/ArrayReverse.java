package array;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ArrayReverse.java
 * @project Basic
 * @package array
 * @date 2024/7/23 23:59
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayReverse {

    public static void main(String[] args) {
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int arr2Length = arr2.length;
        int[] arr3 = new int[arr2Length];
        for (int i = 0; i < arr2Length; i++) {
            arr3[i] = arr2[arr2Length - i - 1];
        }

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + "\t");
        }
    }
}
