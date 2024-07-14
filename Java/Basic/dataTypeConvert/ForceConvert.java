package dataTypeConvert;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ForceConvert.java
 * @project Basic
 * @package dataTypeConvert
 * @date 2024/7/14 0:41
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ForceConvert {

    private static void forceConvert1() {
        int i = (int) 1.9;
        System.out.println(i); // 1，精度缺失，导致结果为 1

        int j = 1;
        byte b1 = (byte) j;
        System.out.println(b1); // -48，造成了数据溢出，导致结果为 -48
    }

    private static void forceConvert2() {
        // int x = (int) 10 * 3.6 * 1.5; // 因为强转符号只针对最近的操作数，所以最后的运算结果是double类型，会导致错误
        int y = (int) (10 * 3.6 * 1.5);
        System.out.println(y);
    }

    private static void forceConvert3() {
        char c1 = 100;
        int m = 100;
//        char c2 = m; // 错误，类型不匹配需要强转
        char c3 = (char) m;
        System.out.println(c3); //输出100对应的字符，d
    }
}
