package com.cmrhyq.learning.exam;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname exam.java
 * @project JavaLearning
 * @package com.cmrhyq.learning.exam
 * @date 2023/5/24 15:18
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class exam {


    public static int uglyNumber(int nums) {
//        if (nums == 0) {
//            return 0;
//        }
//        int[] ugly = {2, 3, 5};
//
//        for (int i = 1; i <= nums; ++i) {
//            while (nums % i == 0 && nums % i < nums) {
//                nums = nums/i;
//            }
//        }
//
//        return 1;
        int ugly = 2;
        for (int i = 0; i < nums; ++i) {
            if (i % ugly == 0) {
                System.out.println(nums);
            }
        }

        return 1;
    }


    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,3,5};
        System.out.println(isStraight(n));
    }
}
