package array;

import java.util.Random;
import java.util.Scanner;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname AscendingArray.java
 * @project Basic
 * @package array
 * @date 2024/7/29 0:28
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class AscendingArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 12, 45, 90};
        System.out.print("Enter the number: ");
        int number = sc.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (number <= arr[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            index = arr.length;
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            // 声明了两个指针i，j
            // i指针指向新数组的每一个位置
            // j指针指向旧数组
            // i指针的值不等于 index索引的时候，只有这个时候才能把j指针当前指向旧数组的指拿给新数组，然后 j指针指向下一位
            // i指针的指等于 index索引的时候，表明 i指针当前所在的位置是要插入的位置，就把要插入的数放到这个位置，然后 j指针不动
            if (i != index) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = number;
            }
        }
        arr = newArr;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

//    public static void main(String[] args) {
//        Random random = new Random();
//        int[] array = new int[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(100) + 1;
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "\t");
//        }
//    }

//    public static void main(String[] args) {
//        int[] array = {24, 69, 80, 57, 13};
//
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < (array.length - 1) - i; j++) {
//                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "\t");
//        }
//    }
}
