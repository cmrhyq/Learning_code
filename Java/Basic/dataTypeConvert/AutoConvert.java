package dataTypeConvert;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname AutoConver.java
 * @project Basic
 * @package PACKAGE_NAME
 * @date 2024/7/10 0:49
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class AutoConvert {

    public static void main(String[] args) {

    }

    private static void autoConvert1() {
        int num2 = 10;
        // 错误原因：num2 + 1.2 的结果的类型是double，因为在运算过程中自动将数据类型转换成了double，所以赋值给float是错误的
//        float f1 = num2 + 1.2;
//        System.out.println(f);

        // 正确写法1
        double d = num2 + 1.2;
        System.out.println(d);

        // 正确写法2
        float f2 = num2 + 1.2F;
        System.out.println(f2);
    }

    private static void autoConvert2() {
        // 错误：精度大的double不能转换成精度小的int
//        int n2 = 1.1;
    }

    private static void autoConvert3() {
        // byte范围：-128 ~ 127
        // 当把数值赋值给 byte 时，先判断这个数值是否在byte的范围内。
        byte b1 = 10;

        // 错误，不在byte范围内
//        byte b3 = 1000;

        // 如果是按照变量赋值，则需要判断类型
        int n1 = 1;
//        byte b2 = n1;

        // 错误，byte 和 char 之间不会互相自动抓换
//        char c1 = b1;
    }

    private static void autoConvert4() {
        byte b1 = 1;
        short s1 = 1;
        // 错误，b1+s1的类型是int
//        short s2 = b1+s1;
    }

    private static void autoConvert5() {
        byte b1 = 1;
        short s1 = 102;
        int n1 = 2;
        double d1 = 1.1;
        // 因为在这些变量中，double是精度最大的数据类型，所以最后的结果转换成了double
        double result = b1 + s1 + n1 + d1;
    }
}
