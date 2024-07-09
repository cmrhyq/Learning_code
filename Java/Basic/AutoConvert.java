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
        int num2 = 10;
//        float f = num2 + 1.2; // 错误原因：num2 + 1.2 的结果的类型是double
        double d2 = num2 + 1.2;
        System.out.println(d2);
    }
}
